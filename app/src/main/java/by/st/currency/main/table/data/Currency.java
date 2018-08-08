package by.st.currency.main.table.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "Currency")
public class Currency implements Parcelable {

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };
    @Attribute
    private String Id;
    @PropertyElement(name = "NumCode")
    private int NumCode;
    @PropertyElement(name = "CharCode")
    private String CharCode;
    @PropertyElement(name = "Scale")
    private double Scale;
    @PropertyElement(name = "Name")
    private String Name;
    @PropertyElement(name = "Rate")
    private double Rate;

    public Currency() {

    }

    private Currency(Parcel in) {
        NumCode = in.readInt();
        Scale = in.readDouble();
        Rate = in.readDouble();
        Id = in.readString();
        CharCode = in.readString();
        Name = in.readString();
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getNumCode() {
        return NumCode;
    }

    public void setNumCode(int NumCode) {
        this.NumCode = NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String CharCode) {
        this.CharCode = CharCode;
    }

    public double getScale() {
        return Scale;
    }

    public void setScale(double Scale) {
        this.Scale = Scale;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(NumCode);
        dest.writeDouble(Scale);
        dest.writeDouble(Rate);
        dest.writeString(Id);
        dest.writeString(CharCode);
        dest.writeString(Name);
    }
}
