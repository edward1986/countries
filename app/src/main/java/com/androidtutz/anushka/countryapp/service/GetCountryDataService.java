package com.androidtutz.anushka.countryapp.service;


import com.androidtutz.anushka.countryapp.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 5/30/2018.
 */
public interface GetCountryDataService {


    @GET("country/get/iso2code/{alpha2_code}")
    Call<Info> getResultByAlpha2Code(@Path("alpha2_code") String alpha2Code);



}
