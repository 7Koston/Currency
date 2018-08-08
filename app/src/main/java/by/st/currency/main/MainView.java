package by.st.currency.main;

import java.util.ArrayList;

import by.st.currency.main.table.data.Currency;

public interface MainView {

    void onGetFinished(ArrayList<Currency> response);

    void onErrorMessage(String error);
}
