package by.st.currency.main;

import android.os.Bundle;

import by.st.currency.LifecycleCallbacks;
import by.st.currency.main.table.data.DailyExRates;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

class MainPresenter extends LifecycleCallbacks {

    private final MainView mainView;
    private final MainRequests mainRequests;
    private DailyExRates dailyExRates;

    MainPresenter(MainView view) {
        this.mainView = view;
        mainRequests = new MainRequests();
    }

    void requestDailyExRates() {
        Disposable subscription = mainRequests.getDailyExRates()
                .subscribeWith(new DisposableSingleObserver<DailyExRates>() {
                    @Override
                    public void onSuccess(DailyExRates response) {
                        dailyExRates = response;
                        mainView.onGetFinished(dailyExRates);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mainView.onErrorMessage("Error");
                    }
                });
        addSubscription(subscription);
    }

    void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            dailyExRates = savedInstanceState.getParcelable("dailyExRates");
            if (dailyExRates != null)
                mainView.onGetFinished(dailyExRates);
        } else
            requestDailyExRates();
    }

    void onSaveInstanceState(Bundle outState) {
        if (dailyExRates != null) {
            outState.putParcelable("dailyExRates", dailyExRates);
        }
    }
}
