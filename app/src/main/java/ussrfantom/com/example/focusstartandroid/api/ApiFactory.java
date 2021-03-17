package ussrfantom.com.example.focusstartandroid.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ussrfantom.com.example.focusstartandroid.pojo.CbrDeserilizerJava;
import ussrfantom.com.example.focusstartandroid.pojo.EmployeeResponse;

public class ApiFactory {
    private static ApiFactory apiFactory;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.cbr-xml-daily.ru/";


    private ApiFactory() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(EmployeeResponse.class, new CbrDeserilizerJava());
        Gson gson = builder.create();
        GsonConverterFactory factory = GsonConverterFactory.create(gson);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    public static ApiFactory getInstance() {
        if (apiFactory == null) {
            apiFactory = new ApiFactory();
        }
        return apiFactory;
    }

    public ApiServise getApiService() {
        return retrofit.create(ApiServise.class);
    }
}
