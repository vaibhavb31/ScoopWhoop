package com.example.scoopwhoop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.scoopwhoop.Adapter.CustomAdapter;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.Model.Show;
import com.example.scoopwhoop.Model.TopShowVideos;
import com.example.scoopwhoop.Model.TopicDisplay;
import com.example.scoopwhoop.Repo.DataRepo;
import com.example.scoopwhoop.Repo.IDataResponse;
import com.example.scoopwhoop.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements IDataResponse {
    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    ArrayList<ArrayList<Data>> dataList = new ArrayList<>();
    ArrayList<ArrayList<TopShowVideos>> dataListVideo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding activityMainBinding;
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        recyclerView = activityMainBinding.recycle;

        DataRepo dataRepo = new DataRepo(this);
        dataRepo.getCarousel();
        initUi();
    }

    private void initUi() {
        customAdapter = new CustomAdapter(new ArrayList<>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);
    }


    @Override
    public void onDataResponse(ArrayList<Data> data) {
        dataList.add(data);
        Log.wtf("dataList", dataList + "");
        customAdapter.refreshList(dataList);
    }

    @Override
    public void onTopDataResponse(List<TopShowVideos> dataList) {
        dataListVideo.add((ArrayList<TopShowVideos>) dataList);
        ArrayList<Data> newDataList =  new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            Data data = new Data();
            data.setTitle(dataList.get(i).getTopic_name());
            data.setFeatureImg(dataList.get(i).getTopic_feature_img());
            Show show = new Show();
            TopicDisplay topicDisplay = new TopicDisplay();
            topicDisplay.setTopicSlug(dataList.get(i).getTopic_slug());
            show.setTopicDisplay(topicDisplay);
            data.setShow(show);
            newDataList.add(data);
        }
        this.dataList.add(newDataList);
        Log.wtf("dataList", dataList + "");
        customAdapter.refreshList(this.dataList);

    }
}