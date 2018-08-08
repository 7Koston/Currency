package by.st.currency;

import android.support.multidex.MultiDexApplication;

import by.st.currency.api.RetrofitClient;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.initialize(getApplicationContext());
    }
}
