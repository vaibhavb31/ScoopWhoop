package com.example.scoopwhoop.Data;

import com.example.scoopwhoop.Model.ApiResponce;
import com.example.scoopwhoop.Model.ApiResponcePagetwo;
import com.example.scoopwhoop.Model.Shows;
import com.example.scoopwhoop.Model.TopShowApiResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetDataService {
    @GET("/uns/api/v1/videos/?filter_type=carousel")
    Call<ApiResponce> getCarousel();

    @GET("/uns/api/v1/videos/")
    Call<ApiResponce> getLatest();

    @GET("/uns/api/v1/videos/?filter_type=uns_edpicks")
    Call<ApiResponce> getEditorPic();

    @GET("/uns/api/v1/all_shows/")
    Call<TopShowApiResponce> getTopShow();


    @GET
    Call<ApiResponcePagetwo> getAllshows(@Url String url);
}
