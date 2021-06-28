package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopShowApiResponce {
    @SerializedName("data")
    private List<TopShowVideos> data;

    public TopShowApiResponce(List<TopShowVideos> data) {
        this.data = data;
    }

    public List<TopShowVideos> getData() {
        return data;
    }

    public void setData(List<TopShowVideos> data) {
        this.data = data;
    }

}
