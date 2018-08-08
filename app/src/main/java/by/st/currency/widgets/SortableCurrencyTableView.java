package by.st.currency.widgets;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import by.st.currency.R;
import by.st.currency.main.table.data.Comparators;
import by.st.currency.main.table.data.Currency;
import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.SortStateViewProviders;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

public class SortableCurrencyTableView extends SortableTableView<Currency> {

    public SortableCurrencyTableView(final Context context) {
        this(context, null);
    }

    public SortableCurrencyTableView(final Context context, final AttributeSet attributes) {
        this(context, attributes, android.R.attr.listViewStyle);
    }

    public SortableCurrencyTableView(final Context context, final AttributeSet attributes,
                                     final int styleAttributes) {
        super(context, attributes, styleAttributes);

        final SimpleTableHeaderAdapter simpleTableHeaderAdapter =
                new SimpleTableHeaderAdapter(context,
                        R.string.char_code, R.string.scale, R.string.name, R.string.rate);
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context,
                R.color.table_header_text));
        setHeaderAdapter(simpleTableHeaderAdapter);

        final int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        final int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(
                rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());

        final TableColumnWeightModel tableColumnWeightModel = new TableColumnWeightModel(4);
        tableColumnWeightModel.setColumnWeight(0, 2);
        tableColumnWeightModel.setColumnWeight(1, 3);
        tableColumnWeightModel.setColumnWeight(2, 3);
        tableColumnWeightModel.setColumnWeight(3, 2);
        setColumnModel(tableColumnWeightModel);

        setColumnComparator(0, Comparators.getCharCodeComparator());
        setColumnComparator(1, Comparators.getScaleComparator());
        setColumnComparator(2, Comparators.getNameComparator());
        setColumnComparator(3, Comparators.getRateComparator());
    }

}