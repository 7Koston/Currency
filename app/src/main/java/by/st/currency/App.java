package by.st.currency;

import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    private static App singletonApp;

    public static App getInstance() {
        return singletonApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.initialize(getApplicationContext());
        Picasso.get().setLoggingEnabled(true);
        singletonApp = this;
    }
}
