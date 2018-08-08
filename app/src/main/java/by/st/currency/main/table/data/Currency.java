package by.st.currency.main.table.data;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class Currency {

    @PropertyElement
    private int NumCode;
    @PropertyElement
    private String CharCode;
    @PropertyElement
    private double Scale;
    @PropertyElement
    private String Name;
    @PropertyElement
    private double Rate;
    @PropertyElement
    private int Id;

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

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
