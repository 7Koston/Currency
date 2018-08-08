package by.st.currency.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import by.st.currency.R;
import by.st.currency.main.table.CurrencyTableDataAdapter;
import by.st.currency.main.table.data.Currency;
import by.st.currency.main.table.data.DailyExRates;
import by.st.currency.widgets.SortableCurrencyTableView;
import de.codecrafters.tableview.listeners.SwipeToRefreshListener;
import de.codecrafters.tableview.listeners.TableDataClickListener;

public class MainActivity extends AppCompatActivity implements MainView,
        TableDataClickListener<Currency>, SwipeToRefreshListener {

    private MainPresenter mainPresenter;

    private SortableCurrencyTableView tableView;
    private RefreshIndicator refreshIndicator;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableView = findViewById(R.id.stvMain);

        v = getWindow().getDecorView().getRootView();

        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate(savedInstanceState);

        setupTableView();
    }


    private void setupTableView() {
        if (tableView != null) {
            tableView.addDataClickListener(this);
            tableView.setSwipeToRefreshEnabled(true);
            tableView.setSwipeToRefreshListener(this);
        }
    }

    private void updateTableView(List<Currency> data) {
        if (tableView != null) {
            tableView.setDataAdapter(new CurrencyTableDataAdapter(this, data));
            if (refreshIndicator != null)
                refreshIndicator.hide();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mainPresenter != null) {
            mainPresenter.onStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mainPresenter.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onGetFinished(DailyExRates response) {
        updateTableView(response.getCurrency());
        setTitle("Currency (" + response.getDate() + ")");
    }

    @Override
    public void onErrorMessage(String error) {
        Snackbar.make(v, error, Snackbar.LENGTH_LONG).show();
        refreshIndicator.hide();
    }

    @Override
    public void onDataClicked(int rowIndex, Currency clickedData) {
        final String str = "Click: " + clickedData.getId() + " " + clickedData.getCharCode();
        Snackbar.make(v, str, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh(RefreshIndicator refreshIndicator) {
        this.refreshIndicator = refreshIndicator;
        mainPresenter.requestDailyExRates();
    }
}
