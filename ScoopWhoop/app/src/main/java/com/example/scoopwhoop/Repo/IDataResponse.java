package com.example.scoopwhoop.Repo;

import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.Model.TopShowVideos;

import java.util.ArrayList;
import java.util.List;

public interface IDataResponse {
    void onDataResponse(ArrayList<Data> dataList);
    void onTopDataResponse(List<TopShowVideos> dataList);

}
