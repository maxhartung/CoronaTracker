package com.sss.coronatracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitClient {
    @GET("api/getPersoane/")
    Call<List<PersonsClass>> cases();
}
