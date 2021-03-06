package ussrfantom.com.example.focusstartandroid.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse {
    @SerializedName("Valute")
    @Expose
    public List<Valute> response = null;

    public EmployeeResponse(List<Valute> valuteList) {
        this.response = valuteList;
    }


    public void setResponse(List<Valute> response) {
        this.response = response;
    }

    public List<Valute> getResponse() {
        return response;
    }

}