package ussrfantom.com.example.focusstartandroid.screens.currency;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ussrfantom.com.example.focusstartandroid.R;

public class CurrencyActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, CurrencyActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
    }
}