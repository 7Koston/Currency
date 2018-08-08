package by.st.currency.main;

import by.st.currency.api.RetrofitClient;
import by.st.currency.main.table.data.DailyExRates;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class MainRequests {

    Single<DailyExRates> getDailyExRates() {
        return RetrofitClient.get()
                .getDailyExRates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
