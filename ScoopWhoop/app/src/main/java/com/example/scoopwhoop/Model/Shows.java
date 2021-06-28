package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

public class Shows {
    @SerializedName("feature_img_port")

    private String featureImgPort;
    @SerializedName("topic_name")

    private String topicName;
    @SerializedName("total_videos")

    private Integer totalVideos;
    @SerializedName("topic_desc")

    private String topicDesc;
    @SerializedName("topic_slug")

    private String topicSlug;
    @SerializedName("feature_img_land")

    private String featureImgLand;
    @SerializedName("onexone_img")

    private String onexoneImg;


    public String getFeatureImgPort() {
        return featureImgPort;
    }

    public void setFeatureImgPort(String featureImgPort) {
        this.featureImgPort = featureImgPort;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getTotalVideos() {
        return totalVideos;
    }

    public void setTotalVideos(Integer totalVideos) {
        this.totalVideos = totalVideos;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicSlug() {
        return topicSlug;
    }

    public void setTopicSlug(String topicSlug) {
        this.topicSlug = topicSlug;
    }

    public String getFeatureImgLand() {
        return featureImgLand;
    }

    public void setFeatureImgLand(String featureImgLand) {
        this.featureImgLand = featureImgLand;
    }

    public String getOnexoneImg() {
        return onexoneImg;
    }

    public void setOnexoneImg(String onexoneImg) {
        this.onexoneImg = onexoneImg;
    }



}
