package by.st.currency;

import android.os.Build;

public final class Constants {

    public final static String USER_AGENT = "Mozilla/5.0 (Android " + Build.VERSION.SDK_INT
            + "; Currency " + BuildConfig.VERSION_NAME + "; " + Build.DEVICE + ")";

    private Constants() {
    }
}
