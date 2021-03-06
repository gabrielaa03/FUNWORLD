package com.gabrielaangebrandt.funworld.MainActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gabrielaangebrandt.funworld.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    TabLayout tabLayout;
    ViewPager viewPager;
    fragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        this.setUp();
    }

    private void setUp() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.colorAccent));
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        pagerAdapter = new fragmentPagerAdapter(getSupportFragmentManager());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }



    // definiranje adaptera za tabove

    public class fragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();

        public fragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getText(R.string.countries);
                case 1:
                    return getText(R.string.games);
            }
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            /*switch(position){
                case 0:
                    return new FragmentCountries();


                case 1:
                    return new FragmentGames();

            }return null;*/

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

    }

    // funkcija za postavljanje adaptera za tabove
    private void setUpViewPager(ViewPager viewPager) {
        fragmentPagerAdapter adapter = new fragmentPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentCountries());
        adapter.addFragment(new FragmentGames());

        viewPager.setAdapter(adapter);

    }


}
