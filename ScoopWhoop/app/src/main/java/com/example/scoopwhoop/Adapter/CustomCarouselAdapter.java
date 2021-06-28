package com.example.scoopwhoop.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.PageTwo;
import com.example.scoopwhoop.databinding.CarouselTileBinding;
import com.example.scoopwhoop.databinding.ImgrowtileBinding;

import java.util.List;

public class CustomCarouselAdapter extends RecyclerView.Adapter<CustomCarouselAdapter.CustomViewHolder> {
    private List<Data> datalist;
    String url="";
    String topicSlug="";



    public CustomCarouselAdapter(List<Data> datalist) {
        this.datalist = datalist;
    }



    @Override
    public CustomCarouselAdapter.CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return  new CustomCarouselAdapter.CustomViewHolder(CarouselTileBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(CustomCarouselAdapter.CustomViewHolder holder, int position) {

        holder.carouselTileBinding.titlecar.setText(datalist.get(position).getTitle());
        Glide.with(holder.carouselTileBinding.getRoot().getContext()).load(datalist.get(position).getVideoThumbnail16x9())
                .into(holder.carouselTileBinding.imgCar);

        holder.carouselTileBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topicSlug= datalist.get(position).getShow().getTopicDisplay().getTopicSlug();
                url= "https://stagingsw.scoopwhoop.com/uns/api/v1/videos/?filter_type=show&filter_slug="+topicSlug+"";

                Intent intent = new Intent(holder.carouselTileBinding.getRoot().getContext(), PageTwo.class);
                intent.putExtra("message", url);
                holder.carouselTileBinding.getRoot().getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private CarouselTileBinding carouselTileBinding;


        public CustomViewHolder( CarouselTileBinding carouselTileBinding) {
            super(carouselTileBinding.getRoot());
            this.carouselTileBinding = carouselTileBinding;
        }
    }
}
