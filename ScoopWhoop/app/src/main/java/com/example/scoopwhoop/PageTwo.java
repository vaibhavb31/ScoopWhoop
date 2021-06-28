package com.example.scoopwhoop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.scoopwhoop.Adapter.CustomAdapter;
import com.example.scoopwhoop.Adapter.CustomAdapterPageTwo;
import com.example.scoopwhoop.Data.GetDataService;
import com.example.scoopwhoop.Data.RetrofitClient;
import com.example.scoopwhoop.Model.ApiResponcePagetwo;
import com.example.scoopwhoop.Model.Shows;
import com.example.scoopwhoop.databinding.ActivityPageTwoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageTwo extends AppCompatActivity {
    private ActivityPageTwoBinding activityPageTwoBinding;
    private CustomAdapterPageTwo customAdapterPageTwo;
    RecyclerView recyclerView;
    TextView title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPageTwoBinding= ActivityPageTwoBinding.inflate(getLayoutInflater());
        View view= activityPageTwoBinding.getRoot();
        recyclerView= activityPageTwoBinding.page2recycle;
        title= activityPageTwoBinding.titlepage2;
        desc= activityPageTwoBinding.description;


        setContentView(view);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");


        GetDataService service = RetrofitClient.getRetrofit().create(GetDataService.class);

        Call<ApiResponcePagetwo> call= service.getAllshows(str);
        call.enqueue(new Callback<ApiResponcePagetwo>() {
            @Override
            public void onResponse(Call<ApiResponcePagetwo> call, Response<ApiResponcePagetwo> response) {
            initUi(response.body());
            title.setText(response.body().getShows().getTopicName());

                Glide.with(activityPageTwoBinding.getRoot().getContext()).load(response.body().getShows().getFeatureImgLand())
                        .into(activityPageTwoBinding.page2img);

                desc.setText(response.body().getShows().getTopicDesc());

            }

            @Override
            public void onFailure(Call<ApiResponcePagetwo> call, Throwable t) {
                Toast.makeText(activityPageTwoBinding.getRoot().getContext(),"fail"+t+"",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initUi(ApiResponcePagetwo api) {

        customAdapterPageTwo= new CustomAdapterPageTwo(api);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapterPageTwo);
    }
}