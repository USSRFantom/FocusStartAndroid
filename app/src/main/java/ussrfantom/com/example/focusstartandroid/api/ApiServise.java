package ussrfantom.com.example.focusstartandroid.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ussrfantom.com.example.focusstartandroid.pojo.EmployeeResponse;

public interface ApiServise {
    @GET("daily_json.js")
    Observable<EmployeeResponse> getEmployees();
}
