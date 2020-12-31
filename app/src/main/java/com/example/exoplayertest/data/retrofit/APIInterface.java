package com.example.exoplayertest.data.retrofit;

import com.example.exoplayertest.data.model.AuthBody;
import com.example.exoplayertest.data.model.MediaObject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    //Registration
    @POST("index.php?p=showAllVideos")
    Observable<Response<MediaObject>> getFeed(@Body AuthBody authBody);

}
