package com.example.scoopwhoop.Repo;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoopwhoop.Data.GetDataService;
import com.example.scoopwhoop.Data.RetrofitClient;
import com.example.scoopwhoop.Model.ApiResponce;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.Model.TopShowApiResponce;
import com.example.scoopwhoop.Model.TopShowVideos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepo  {
    IDataResponse iDataResponse;


    public DataRepo(IDataResponse iDataResponse) {
        this.iDataResponse = iDataResponse;
    }


    public void getCarousel() {
        GetDataService service= RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<ApiResponce> call= service.getCarousel();
        call.enqueue(new Callback<ApiResponce>() {
            @Override
            public void onResponse(Call<ApiResponce> call, Response<ApiResponce> response) {
                iDataResponse.onDataResponse((ArrayList<Data>) response.body().getData());
                getLatest();
            }

            @Override
            public void onFailure(Call<ApiResponce> call, Throwable t) {

            }
        });

    }
    public void getLatest() {
        GetDataService service= RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<ApiResponce> call= service.getLatest();
        call.enqueue(new Callback<ApiResponce>() {
            @Override
            public void onResponse(Call<ApiResponce> call, Response<ApiResponce> response) {
                iDataResponse.onDataResponse((ArrayList<Data>) response.body().getData());
                getEditorsPick();
            }

            @Override
            public void onFailure(Call<ApiResponce> call, Throwable t) {

            }
        });

    }

    public void getEditorsPick() {
        GetDataService service= RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<ApiResponce> call= service.getEditorPic();
        call.enqueue(new Callback<ApiResponce>() {
            @Override
            public void onResponse(Call<ApiResponce> call, Response<ApiResponce> response) {
                iDataResponse.onDataResponse((ArrayList<Data>) response.body().getData());
                getTopShows();
            }

            @Override
            public void onFailure(Call<ApiResponce> call, Throwable t) {

            }
        });

    }

    public void getTopShows() {
        GetDataService service= RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<TopShowApiResponce> call= service.getTopShow();
        call.enqueue(new Callback<TopShowApiResponce>() {
            @Override
            public void onResponse(Call<TopShowApiResponce> call, Response<TopShowApiResponce> response) {
                iDataResponse.onTopDataResponse(response.body().getData());
            }

            @Override
            public void onFailure(Call<TopShowApiResponce> call, Throwable t) {
                Log.wtf("vaibhav",t);
            }
        });

    }
}