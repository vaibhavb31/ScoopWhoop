package com.example.scoopwhoop.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

        private static Retrofit retrofit;
        private static final String baseURL="https://stagingsw.scoopwhoop.com";

        public static Retrofit getRetrofit() {
            if(retrofit==null)
            {
                retrofit= new Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }


            return retrofit;
        }
    }

