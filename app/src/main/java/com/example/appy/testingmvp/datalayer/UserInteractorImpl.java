package com.example.appy.testingmvp.datalayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Appy on 13/06/16.
 */

public class UserInteractorImpl implements UserInteractor {

    private Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void giveAllUsers(final OnUsersLoadingFinished listener) {
         UserApi api=retrofit.create(UserApi.class);
         Call<List<User>> call=api.getUsers();
         call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                listener.onSuccess(response.body());
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }
}
