package by.st.currency.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class FragmentsUtils {

    public static void replaceFragment(
            @NonNull FragmentManager supportFragmentManager,
            @IdRes int fragmentContainer,
            @NonNull Fragment newFragment,
            @Nullable String TAG) {

        newFragment = findFragment(supportFragmentManager, newFragment, TAG);

        String tag;
        if (TAG != null)
            tag = TAG;
        else
            tag = getFragmentTag(newFragment);

        supportFragmentManager
                .beginTransaction()
                .replace(fragmentContainer, newFragment, tag)
                .commit();
    }

    private static @NonNull
    Fragment findFragment(
            @NonNull FragmentManager supportFragmentManager, @NonNull Fragment newFragment, @Nullable String TAG) {

        String newFragmentClass = getFragmentTag(newFragment);

        Fragment oldFragment = null;
        if (TAG != null)
            oldFragment = supportFragmentManager.findFragmentByTag(TAG);
        if (oldFragment == null)
            oldFragment = supportFragmentManager.findFragmentByTag(newFragmentClass);
        if (oldFragment == null)
            oldFragment = supportFragmentManager.findFragmentByTag(newFragment.getTag());
        if (oldFragment == null)
            oldFragment = supportFragmentManager.findFragmentById(newFragment.getId());

        if (oldFragment != null) {
            newFragment = oldFragment;
            Log.d(FragmentsUtils.class.getName(), "Fragment founded: " + newFragmentClass);
        }

        return newFragment;
    }

    private static @Nullable
    String getFragmentTag(Fragment fragment) {
        if (fragment != null)
            return fragment.getClass().getName();
        else
            return null;
    }

    public static void removeFragment(@NonNull FragmentManager supportFragmentManager, @NonNull String TAG) {
        if (supportFragmentManager.findFragmentByTag(TAG) != null &&
                supportFragmentManager.findFragmentByTag(TAG).isAdded())
            supportFragmentManager
                    .beginTransaction()
                    .remove(supportFragmentManager.findFragmentByTag(TAG))
                    .commit();
    }
}
