package com.androidtutz.anushka.countryapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 5/28/2018.
 */
public class Info {

    @SerializedName("RestResponse")
    private RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }


}
