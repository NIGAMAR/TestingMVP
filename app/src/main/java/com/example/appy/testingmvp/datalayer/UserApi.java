package com.example.appy.testingmvp.datalayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Appy on 13/06/16.
 */

public interface UserApi {
    @GET("/users")
    Call<List<User>> getUsers();
}
