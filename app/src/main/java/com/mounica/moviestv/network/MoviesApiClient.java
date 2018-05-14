package com.mounica.moviestv.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mounicachikkam on 5/9/18.
 */

public class MoviesApiClient {

  public static final String BASE_URL = "https://api.themoviedb.org/3/";
  public static Retrofit retrofit = null;

  public static Retrofit getClient() {
    if (retrofit == null) {
      //Interceptor
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
      //create Retrofit instance
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(client)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
