package ussrfantom.com.example.focusstartandroid;

import android.app.Application;

import ussrfantom.com.example.focusstartandroid.data.prefs.Prefs;
import ussrfantom.com.example.focusstartandroid.data.prefs.PrefsImpl;

public class App extends Application {

    private Prefs prefs;


    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new PrefsImpl(this);
    }

    public Prefs getPrefs() {
        return prefs;
    }
}
