package by.st.currency.main.table.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.ArrayList;

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
    @PropertyElement
    private String Date;
    @Element
    private ArrayList<Currency> currency;

    private DailyExRates(Parcel in) {
        Date = in.readString();
        in.readList(currency, Currency.class.getClassLoader());
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public ArrayList<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(ArrayList<Currency> Currency) {
        this.currency = Currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Date);
        dest.writeList(currency);
    }
}
