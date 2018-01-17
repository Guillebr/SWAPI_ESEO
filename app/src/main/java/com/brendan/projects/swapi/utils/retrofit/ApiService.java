package com.brendan.projects.swapi.utils.retrofit;

import com.brendan.projects.swapi.BuildConfig;
import com.brendan.projects.swapi.models.ElementFilms;
import com.brendan.projects.swapi.models.ElementPeople;
import com.brendan.projects.swapi.models.ElementPlanets;
import com.brendan.projects.swapi.models.ElementSpecies;
import com.brendan.projects.swapi.models.ElementStarships;
import com.brendan.projects.swapi.models.ElementVehicles;
import com.brendan.projects.swapi.utils.gson.ArrayAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    @GET("films/")
    Call<List<ElementFilms>> getFilms();

    @GET("people/")
    Call<List<ElementPeople>> getPeople();

    @GET("planets/")
    Call<List<ElementPlanets>> getPlanets();

    @GET("species/")
    Call<List<ElementSpecies>> getSpecies();

    @GET("starships/")
    Call<List<ElementStarships>> getStarships();

    @GET("vehicles/")
    Call<List<ElementVehicles>> getVehicles();

    class Builder {
        /**
         * Create a singleton only for simplicity. Should be done through a DI system instead.
         */
        private static final ApiService instance = build();

        public static ApiService getInstance() {
            return instance;
        }

        private Builder() {
        }

        /**
         * Build an ApiService instance
         */
        private static ApiService build() {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ArrayAdapterFactory()).create();

            // Create the OkHttp Instance
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(final Chain chain) throws IOException {
                            final Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            return new Retrofit.Builder()
                    .baseUrl("https://swapi.co/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiService.class);
        }
    }
}