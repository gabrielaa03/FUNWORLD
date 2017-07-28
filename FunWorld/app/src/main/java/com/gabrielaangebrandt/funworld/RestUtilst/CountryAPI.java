package com.gabrielaangebrandt.funworld.RestUtilst;

import com.gabrielaangebrandt.funworld.data_model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Gabriela on 30.5.2017..
 */

public interface CountryAPI {
    @GET("{name}")
    Call<List<Example>> getCountry(@Path("name") String name);
}
