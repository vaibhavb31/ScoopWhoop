package com.example.scoopwhoop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopShowVideos {
    @SerializedName("topic_feature_img")
    private String topic_feature_img;

    @SerializedName("topic_name")
    private String topic_name;

    @SerializedName("topic_slug")
    private String topic_slug;

    public TopShowVideos(String topic_feature_img, String topic_name, String topic_slug) {
        this.topic_feature_img = topic_feature_img;
        this.topic_name = topic_name;
        this.topic_slug = topic_slug;
    }

    public String getTopic_feature_img() {
        return topic_feature_img;
    }

    public void setTopic_feature_img(String topic_feature_img) {
        this.topic_feature_img = topic_feature_img;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getTopic_slug() {
        return topic_slug;
    }

    public void setTopic_slug(String topic_slug) {
        this.topic_slug = topic_slug;
    }
}
