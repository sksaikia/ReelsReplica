package com.example.exoplayertest.data.model;

import com.google.gson.annotations.SerializedName;

public class MainResponseBody {

    private String id;

    private String video;

    private String thum;

    private String liked;

    public String getLiked(){
        return liked;
    }

    @SerializedName("user_info")
    public UserInfo userInfo;

    public UserInfo getUserInfo(){
        return userInfo;
    }
    public String getId() {
        return id;
    }

    public String getVideo() {
        return video;
    }

    public String getThum() {
        return thum;
    }
}
