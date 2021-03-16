package ussrfantom.com.example.focusstartandroid.screens.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import ussrfantom.com.example.focusstartandroid.App;
import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.data.prefs.Prefs;
import ussrfantom.com.example.focusstartandroid.screens.start.StartActivity;

public class WelcomeActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, WelcomeActivity.class);
        context.startActivity(starter);
    }

    public static void startInNewTask(Context context) {
        Intent starter = new Intent(context, WelcomeActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
    }


    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.button_start)
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        pager.setAdapter(new WelcomePagerAdapter(getSupportFragmentManager()));
        Prefs prefs = ((App) getApplication()).getPrefs();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefs.setFirstLaunch(false);
                StartActivity.startInNewTask(WelcomeActivity.this);
            }
        });
    }
}