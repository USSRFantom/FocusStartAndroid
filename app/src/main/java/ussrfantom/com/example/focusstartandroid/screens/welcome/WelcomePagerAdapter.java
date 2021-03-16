package ussrfantom.com.example.focusstartandroid.screens.welcome;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.focusstartandroid.R;

public class WelcomePagerAdapter extends FragmentPagerAdapter {

    private List<WelcomePage> pages;

    WelcomePagerAdapter(FragmentManager fm) {
        super(fm);
        pages = new ArrayList<>();
        pages.add(new WelcomePage(R.drawable.welcome_icone_1, R.string.welcome_title_1, R.string.welcome_subtitle_1));
        pages.add(new WelcomePage(R.drawable.welcome_icone_2, R.string.welcome_title_2, R.string.welcome_subtitle_2));
        pages.add(new WelcomePage(R.drawable.welcome_icone_3, R.string.welcome_title_3, R.string.welcome_subtitle_3));
    }


    @Override
    public Fragment getItem(int position) {
        return WelcomeFragment.newInstance(pages.get(position));
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
