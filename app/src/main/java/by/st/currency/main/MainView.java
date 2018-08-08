package by.st.currency.main;

import by.st.currency.main.table.data.DailyExRates;

interface MainView {

    void onGetFinished(DailyExRates response);

    void onErrorMessage(String error);
}
