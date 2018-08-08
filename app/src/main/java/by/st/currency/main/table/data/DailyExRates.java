package by.st.currency.main.table.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.ArrayList;
import java.util.List;

@Xml
public class DailyExRates implements Parcelable {

    public static final Creator<DailyExRates> CREATOR = new Creator<DailyExRates>() {
        @Override
        public DailyExRates createFromParcel(Parcel in) {
            return new DailyExRates(in);
        }

        @Override
        public DailyExRates[] newArray(int size) {
            return new DailyExRates[size];
        }
    };

    @Element(name = "Currency")
    private List<Currency> currency;
    @Attribute(name = "Date")
    private String date;

    public DailyExRates() {

    }

    private DailyExRates(Parcel in) {
        date = in.readString();
        if (currency == null)
            currency = new ArrayList<>();
        in.readList(currency, Currency.class.getClassLoader());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public List<Currency> getCurrency() {
        return this.currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeList(currency);
    }
}
