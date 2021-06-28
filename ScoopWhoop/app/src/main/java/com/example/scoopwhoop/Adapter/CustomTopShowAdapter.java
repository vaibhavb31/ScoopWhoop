package com.example.scoopwhoop.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.Model.TopShowVideos;
import com.example.scoopwhoop.PageTwo;
import com.example.scoopwhoop.databinding.ImgrowtileBinding;

import java.util.List;


public class CustomTopShowAdapter extends RecyclerView.Adapter<CustomTopShowAdapter.CustomViewHolder> {
    private List<TopShowVideos> datalist;
    String url="";
    String topicSlug="";



    public CustomTopShowAdapter(List<TopShowVideos> datalist) {
        this.datalist = datalist;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(ImgrowtileBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(CustomTopShowAdapter.CustomViewHolder holder, int position) {

holder.imgrowtileBinding.title.setText(datalist.get(position).getTopic_name());
        Glide.with(holder.imgrowtileBinding.getRoot().getContext()).load(datalist.get(position).getTopic_feature_img())
               .into(holder.imgrowtileBinding.img);



        holder.imgrowtileBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topicSlug= datalist.get(position).getTopic_slug();
                url= "https://stagingsw.scoopwhoop.com/uns/api/v1/videos/?filter_type=show&filter_slug="+topicSlug+"";

                Intent intent = new Intent(holder.imgrowtileBinding.getRoot().getContext(), PageTwo.class);
                intent.putExtra("message", url);
                holder.imgrowtileBinding.getRoot().getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImgrowtileBinding imgrowtileBinding;


        public CustomViewHolder( ImgrowtileBinding imgrowtileBinding) {
            super(imgrowtileBinding.getRoot());
            this.imgrowtileBinding = imgrowtileBinding;
        }
    }

}
