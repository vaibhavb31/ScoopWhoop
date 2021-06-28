package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponce {
    @SerializedName("data")
    private List<Data> data;

    public ApiResponce(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
