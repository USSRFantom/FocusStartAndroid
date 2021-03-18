package ussrfantom.com.example.focusstartandroid.screens.currency;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.adapter.EmployeeAdapter;
import ussrfantom.com.example.focusstartandroid.api.ApiFactory;
import ussrfantom.com.example.focusstartandroid.api.ApiServise;
import ussrfantom.com.example.focusstartandroid.pojo.EmployeeResponse;
import ussrfantom.com.example.focusstartandroid.pojo.Valute;
import ussrfantom.com.example.focusstartandroid.screens.change.ChangeActivity;

public class CurrencyActivity extends AppCompatActivity {

    private RecyclerView recyclerViewValute;
    private EmployeeAdapter adapter;
    private Disposable disposable;
    private CompositeDisposable compositeDisposable;
    private Button buttonChange;
    public List<Valute> response;


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
        compositeDisposable = new CompositeDisposable();
        disposable = apiServise.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EmployeeResponse>() {
                    @Override
                    public void accept(EmployeeResponse employeeResponse) throws Exception {
                        adapter.setValutes(employeeResponse.getResponse());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
        compositeDisposable.add(disposable);

        adapter.setOnPosClickListener(new EmployeeAdapter.OnPosClickListener() {
            @Override
            public void onPosClick(int position) {
                List<Valute> valuteList = adapter.getValutes();
                Valute valute = valuteList.get(position);
                Intent intent = new Intent(CurrencyActivity.this, ChangeActivity.class);
                intent.putExtra("Name", valute.getName());
                intent.putExtra("Nominal", valute.getNominal());
                intent.putExtra("Previous", valute.getPrevious());
                intent.putExtra("Value", valute.getValue());
                startActivity(intent);


            }
        });
    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }


}