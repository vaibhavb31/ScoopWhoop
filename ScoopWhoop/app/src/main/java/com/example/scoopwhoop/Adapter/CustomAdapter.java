package com.example.scoopwhoop.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.scoopwhoop.Data.GetDataService;
import com.example.scoopwhoop.Data.RetrofitClient;
import com.example.scoopwhoop.Model.ApiResponce;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.Model.TopShowApiResponce;
import com.example.scoopwhoop.Model.TopShowVideos;
import com.example.scoopwhoop.Repo.DataRepo;
import com.example.scoopwhoop.databinding.RowtileBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import me.relex.circleindicator.CircleIndicator2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<ArrayList<Data>> datalist;
    private CustomVideoAdapter customVideoAdapter;
    private CustomCarouselAdapter customCarouselAdapter;
    private CustomTopShowAdapter customTopShowAdapter;
    //private Context context;
    CustomAdapter.CustomViewHolder customViewHolder;
    int position;

    public CustomAdapter(ArrayList<ArrayList<Data>> datalist) {
        this.datalist = datalist;
        //this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowtileBinding rowtileBinding = RowtileBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new CustomViewHolder(rowtileBinding);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
        if (position == 0) {
            //holder.rowTileBinding.sectionname.setText("Carousel");
            holder.initUiCarousel(datalist.get(position), holder.rowTileBinding.getRoot().getContext());

        } else if (position == 1) {
            holder.rowTileBinding.sectionname.setText("Latest");
            holder.initUi(datalist.get(position), holder.rowTileBinding.getRoot().getContext());

        } else if (position == 2) {
            holder.rowTileBinding.sectionname.setText("Editor Pick");
            holder.initUi(datalist.get(position), holder.rowTileBinding.getRoot().getContext());

        } else if (position == 3) {
            holder.rowTileBinding.sectionname.setText("Top Shows");
            holder.initUi(datalist.get(position), holder.rowTileBinding.getRoot().getContext());

        }

    }

    public void refreshList(ArrayList<ArrayList<Data>> dataList) {
        this.datalist = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        private RowtileBinding rowTileBinding;

        public CustomViewHolder(RowtileBinding rowTileBinding) {
            super(rowTileBinding.getRoot());
            this.rowTileBinding = rowTileBinding;
            //context = rowTileBinding.getRoot().getContext();
        }

        public void initUi(List<Data> data, Context context) {
            customVideoAdapter = new CustomVideoAdapter(data);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rowTileBinding.recycleall.setLayoutManager(layoutManager);
            rowTileBinding.recycleall.setAdapter(customVideoAdapter);
        }
        public void initUiCarousel(List<Data> data, Context context) {
            customCarouselAdapter = new CustomCarouselAdapter(data);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rowTileBinding.recycleall.setLayoutManager(layoutManager);
            rowTileBinding.recycleall.setAdapter(customCarouselAdapter);

            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            rowTileBinding.recycleall.setOnFlingListener(null);
            pagerSnapHelper.attachToRecyclerView(rowTileBinding.recycleall);

            CircleIndicator2 indicator = rowTileBinding.indicator;
            indicator.attachToRecyclerView(rowTileBinding.recycleall, pagerSnapHelper);
        }

        public void initUiTopShow(List<TopShowVideos> data, Context context) {
            customTopShowAdapter = new CustomTopShowAdapter(data);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rowTileBinding.recycleall.setLayoutManager(layoutManager);
            rowTileBinding.recycleall.setAdapter(customTopShowAdapter);
        }
    }
}