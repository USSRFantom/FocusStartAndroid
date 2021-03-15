package ussrfantom.com.example.focusstartandroid.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsImpl implements Prefs {

    private static final String PREFS_NAME = "prefs";
    private static final String KEY_FIRST_LAUNCH = "first_launch";

    private Context context;

    public PrefsImpl(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isFirstLaunch() {
        return getSharedPreferences().getBoolean(KEY_FIRST_LAUNCH, true);
    }

    @Override
    public void setFirstLaunch(boolean firstLaunch) {
        getSharedPreferences().edit()
                .putBoolean(KEY_FIRST_LAUNCH, firstLaunch)
                .apply();
    }
}
