package com.asii.room_mvvm_retrofit.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsApiService {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private DogsApi dogsApi;

    public DogsApiService() {
        this.dogsApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DogsApi.class);
    }

    public Single<List<Dog>> getDogs(){
        return dogsApi.getDogs();
    }
}
