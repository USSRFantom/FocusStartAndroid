package ussrfantom.com.example.focusstartandroid.screens.start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.screens.currency.CurrencyActivity;

public class StartActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    public static void start(Context context) {
        Intent starter = new Intent(context, StartActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
    }

    public static void startInNewTask(Context context) {
        Intent starter = new Intent(context, StartActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent intent = new Intent(getApplicationContext(), CurrencyActivity.class);
                                          startActivity(intent);
                                          finish();
                                      }
                                  }, SPLASH_TIMER
        );
    }
}