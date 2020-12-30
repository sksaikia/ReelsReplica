package com.example.exoplayertest.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaObject {

    private String code;

    @SerializedName("msg")
    ArrayList<MainResponseBody> list;

    public String getCode() {
        return code;
    }

    public ArrayList<MainResponseBody> getList() {
        return list;
    }
}
