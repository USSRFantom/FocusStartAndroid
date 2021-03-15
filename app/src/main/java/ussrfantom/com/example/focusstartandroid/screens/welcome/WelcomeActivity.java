package ussrfantom.com.example.focusstartandroid.screens.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ussrfantom.com.example.focusstartandroid.R;

public class WelcomeActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, WelcomeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}