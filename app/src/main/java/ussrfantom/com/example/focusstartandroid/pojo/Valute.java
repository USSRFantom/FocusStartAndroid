package ussrfantom.com.example.focusstartandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Valute {

    @SerializedName("Nominal")
    @Expose
    private int Nominal;

    @SerializedName("Name")
    @Expose
    private String Name;

    @SerializedName("Value")
    @Expose
    private Double value;

    @SerializedName("Previous")
    @Expose
    private Double Previous;


    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPrevious() {
        return Previous;
    }

    public void setPrevious(Double previous) {
        Previous = previous;
    }
}