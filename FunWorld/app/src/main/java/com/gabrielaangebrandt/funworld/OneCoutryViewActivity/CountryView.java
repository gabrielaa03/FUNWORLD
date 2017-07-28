package com.gabrielaangebrandt.funworld.OneCoutryViewActivity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabrielaangebrandt.funworld.R;

public class CountryView extends AppCompatActivity implements CountryInterface{
    TextView tv_name, tv_population, tv_area, tv_region, tv_alphaCode, tv_capital, tv_currency, tv_language;
    ImageView imageView;
    CountryPresenter presenter;
    String nameOfCountry="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_view_layout);

        presenter = new CountryPresenter();

        tv_name = (TextView) findViewById(R.id.countryTitle);
        tv_population = (TextView) findViewById(R.id.tv_population_value);
        tv_region = (TextView) findViewById(R.id.tv_region_value);
        tv_area = (TextView) findViewById(R.id.tv_area_value);
        tv_alphaCode = (TextView) findViewById(R.id.tv_alphacode_value);
        tv_capital = (TextView) findViewById(R.id.tv_capital_value);
        tv_currency = (TextView) findViewById(R.id.tv_currency_value);
        tv_language = (TextView) findViewById(R.id.tv_language_value);
        imageView = (ImageView) findViewById(R.id.iv_flag);

        nameOfCountry = getIntent().getExtras().getString("nameOfCountry");
        presenter.getData(nameOfCountry, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void sendData(String name, Integer population, Double area, String region, String alphaCode3, String alphaCode2, String capital, String language, String currency) {
            String lowercaseAlphaCode2 = alphaCode2.toLowerCase();
            tv_name.setText(nameOfCountry);
            tv_population.setText(String.valueOf(population));
            tv_region.setText(region);
            tv_alphaCode.setText(alphaCode3);
            tv_capital.setText(capital);
            tv_area.setText(String.valueOf(area));
            tv_currency.setText(String.valueOf(currency));
            tv_language.setText(String.valueOf(language));
            imageView.setImageResource(getResources().getIdentifier("com.gabrielaangebrandt.funworld:drawable/" + lowercaseAlphaCode2, null, null));


    }
}
