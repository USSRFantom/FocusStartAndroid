package ussrfantom.com.example.focusstartandroid.screens.launch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ussrfantom.com.example.focusstartandroid.App;
import ussrfantom.com.example.focusstartandroid.data.prefs.Prefs;
import ussrfantom.com.example.focusstartandroid.screens.start.StartActivity;
import ussrfantom.com.example.focusstartandroid.screens.welcome.WelcomeActivity;

public class LaunchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Prefs prefs = ((App) getApplication()).getPrefs();

        if (prefs.isFirstLaunch()) {
            WelcomeActivity.start(this);
        } else {
            StartActivity.start(this);
        }
        finish();
    }
}