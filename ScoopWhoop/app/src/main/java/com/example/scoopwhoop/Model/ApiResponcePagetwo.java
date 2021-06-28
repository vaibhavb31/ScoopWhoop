package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponcePagetwo {
    @SerializedName("show_details")
    private Shows shows;

        @SerializedName("data")
        private List<Datum> data;


    public ApiResponcePagetwo(Shows shows, List<Datum> data) {
        this.shows = shows;
        this.data = data;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
}
