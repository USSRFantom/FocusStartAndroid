package ussrfantom.com.example.focusstartandroid.screens.currency;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.adapter.EmployeeAdapter;
import ussrfantom.com.example.focusstartandroid.pojo.Valute;

public class CurrencyActivity extends AppCompatActivity {

    private RecyclerView recyclerViewValute;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        recyclerViewValute = findViewById(R.id.recyclerCiewCurrency);
        adapter = new EmployeeAdapter();
        recyclerViewValute.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewValute.setAdapter(adapter);
        List<Valute> valutes = new ArrayList<>();
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


    }

}