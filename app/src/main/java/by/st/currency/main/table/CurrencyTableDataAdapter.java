package by.st.currency.main.table;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import by.st.currency.main.table.data.Currency;
import de.codecrafters.tableview.TableDataAdapter;

public class CurrencyTableDataAdapter extends TableDataAdapter<Currency> {

    private static final int TEXT_SIZE = 14;

    public CurrencyTableDataAdapter(final Context context, final List<Currency> data) {
        super(context, data);
    }

    private View renderCharCode(final Currency currency) {
        return renderString(currency.getCharCode());
    }

    private View renderRate(final Currency currency) {
        return renderNumber(currency.getRate());
    }

    private View renderName(final Currency currency) {
        return renderString(currency.getName());
    }

    private View renderScale(final Currency currency) {
        return renderNumber(currency.getScale());
    }

    private View renderString(final String value) {
        final TextView textView = new TextView(getContext());
        textView.setText(value);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    private View renderNumber(final double value) {
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(value));
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        final Currency currency = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderCharCode(currency);
                break;
            case 1:
                renderedView = renderScale(currency);
                break;
            case 2:
                renderedView = renderName(currency);
                break;
            case 3:
                renderedView = renderRate(currency);
                break;
        }

        return renderedView;
    }
}
