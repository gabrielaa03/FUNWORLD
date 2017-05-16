package com.gabrielaangebrandt.funworld;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);


        // Give the TabLayout the ViewPager

        tabLayout.addTab(tabLayout.newTab().setText(getText(R.string.countries)));
        tabLayout.addTab(tabLayout.newTab().setText(getText(R.string.games)));

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, FragmentCountries.class.getName()));
        fragments.add(Fragment.instantiate(this, MyFirstTabFragment.class.getName()));

        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),fragments));

        tabLayout.setupWithViewPager(viewPager);

    }
}
