package com.example.scoopwhoop.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.scoopwhoop.Model.Data;
import com.example.scoopwhoop.PageTwo;
import com.example.scoopwhoop.R;
import com.example.scoopwhoop.databinding.ImgrowtileBinding;

import java.util.List;



public class CustomVideoAdapter extends RecyclerView.Adapter<CustomVideoAdapter.CustomViewHolder> {
    private List<Data> datalist;
    String url="";
    String topicSlug="";



    public CustomVideoAdapter(List<Data> datalist) {
        this.datalist = datalist;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(ImgrowtileBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(CustomVideoAdapter.CustomViewHolder holder, int position) {

holder.imgrowtileBinding.title.setText(datalist.get(position).getTitle());
        Glide.with(holder.imgrowtileBinding.getRoot().getContext()).load(datalist.get(position).getFeatureImg())
               .into(holder.imgrowtileBinding.img);



        holder.imgrowtileBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topicSlug= datalist.get(position).getShow().getTopicDisplay().getTopicSlug();
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
