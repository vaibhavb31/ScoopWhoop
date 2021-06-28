package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

public class Datum {



        @SerializedName("title")

        private String title;



        @SerializedName("feature_img")

        private String featureImg;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getFeatureImg() {
            return featureImg;
        }

        public void setFeatureImg(String featureImg) {
            this.featureImg = featureImg;
        }


}
