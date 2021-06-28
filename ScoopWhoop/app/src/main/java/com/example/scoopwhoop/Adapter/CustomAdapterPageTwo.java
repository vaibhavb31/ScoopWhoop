package com.example.scoopwhoop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scoopwhoop.Model.ApiResponce;
import com.example.scoopwhoop.Model.ApiResponcePagetwo;
import com.example.scoopwhoop.Model.Shows;
import com.example.scoopwhoop.databinding.ImgrowtileBinding;
import com.example.scoopwhoop.databinding.Page2rowtileBinding;

import java.util.List;

public class CustomAdapterPageTwo extends RecyclerView.Adapter<CustomAdapterPageTwo.CustomViewHolderPageTwo> {
    private ApiResponcePagetwo datalist;

    public CustomAdapterPageTwo(ApiResponcePagetwo shows) {
        this.datalist= shows;
    }

    @Override
    public CustomViewHolderPageTwo onCreateViewHolder( ViewGroup parent, int viewType) {

        return new CustomAdapterPageTwo.CustomViewHolderPageTwo(Page2rowtileBinding.inflate(LayoutInflater.from(parent.getContext())
                , parent, false
        ));
    }

    @Override
    public void onBindViewHolder( CustomAdapterPageTwo.CustomViewHolderPageTwo holder, int position) {
    holder.page2rowtileBinding.titlepage2tile.setText(datalist.getData().get(position).getTitle());

        Glide.with(holder.page2rowtileBinding.getRoot().getContext()).load(datalist.getData().get(position).getFeatureImg())
                .into(holder.page2rowtileBinding.imgpage2tile);
    }

    @Override
    public int getItemCount() {
        return datalist.getData().size();
    }

    class CustomViewHolderPageTwo extends RecyclerView.ViewHolder {
        private Page2rowtileBinding page2rowtileBinding;

        public CustomViewHolderPageTwo(Page2rowtileBinding page2rowtileBinding) {
            super(page2rowtileBinding.getRoot());
            this.page2rowtileBinding=page2rowtileBinding;
        }
    }
}
