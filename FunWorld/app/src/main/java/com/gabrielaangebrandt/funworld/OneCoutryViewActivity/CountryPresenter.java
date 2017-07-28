package com.gabrielaangebrandt.funworld.OneCoutryViewActivity;

import com.gabrielaangebrandt.funworld.RestUtilst.Utils;
import com.gabrielaangebrandt.funworld.data_model.Currency;
import com.gabrielaangebrandt.funworld.data_model.Example;
import com.gabrielaangebrandt.funworld.data_model.Language;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gabriela on 22.7.2017..
 */

public class CountryPresenter {
    private Call<List<Example>> callExample;

    public void getData(String name, final CountryInterface listener){
        callExample = Utils.getApi().getCountry(name);
        callExample.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                List<Example> country = response.body();
                String name = "";
                Integer population = null;
                Double area  = null;
                String region = "";
                String alphaCode3 = "";
                String alphaCode2 = "";
                String capital = "";
                List<Language> languageList = new ArrayList<>();
                List<Currency> currencyList = new ArrayList<>();
                String language = "";
                String currency = "";

                for(int i=0; i<country.size(); i++) {

                    name = country.get(i).getName();
                    population = country.get(i).getPopulation();
                    area = country.get(i).getArea();
                    region = country.get(i).getRegion();
                    alphaCode3 = country.get(i).getAlpha3Code();
                    alphaCode2 = country.get(i).getAlpha2Code();
                    capital = country.get(i).getCapital();
                    languageList = country.get(i).getLanguages();
                    currencyList = country.get(i).getCurrencies();
                }

                for(int i=0; i< languageList.size();i++){
                    language = languageList.get(i).getName();
                }

                for(int i=0; i<currencyList.size();i++){
                    currency = currencyList.get(i).getName();
                }


             listener.sendData(name, population, area, region, alphaCode3, alphaCode2, capital, language, currency);

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
    }
}
