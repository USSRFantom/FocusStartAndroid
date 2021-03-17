package ussrfantom.com.example.focusstartandroid.screens.currency;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.adapter.EmployeeAdapter;
import ussrfantom.com.example.focusstartandroid.api.ApiFactory;
import ussrfantom.com.example.focusstartandroid.api.ApiServise;
import ussrfantom.com.example.focusstartandroid.pojo.EmployeeResponse;

public class CurrencyActivity extends AppCompatActivity {

    private RecyclerView recyclerViewValute;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        recyclerViewValute = findViewById(R.id.recyclerCiewCurrency);
        adapter = new EmployeeAdapter();
        adapter.setValutes(new ArrayList<>());
        recyclerViewValute.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewValute.setAdapter(adapter);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiServise apiServise = apiFactory.getApiService();
        apiServise.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        adapter.setValutes(employeeResponse.getResponse());
                        Log.i("123123123121", "Данные получены");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("123123123121", throwable.getMessage());
                    }
                });





        /*List<Valute> valutes = new ArrayList<>();
        Valute valute1 = new Valute();
        Valute valute2 = new Valute();
        valute1.setName("ghjgjjggg");
        valute2.setName("gsdfdsfsdggg");
        valute1.setPrevious(1.6);
        valute2.setPrevious(1.3);
        valute1.setValue(0.33);
        valute2.setValue(0.55);
        valute1.setNominal(10);
        valute2.setNominal(222);
        valutes.add(valute1);
        valutes.add(valute2);
        adapter.setValutes(valutes);
        Log.i("9999999", String.valueOf(valutes.size()));


         */


    }

}