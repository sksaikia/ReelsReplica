package com.example.exoplayertest.data.retrofit;

import com.example.exoplayertest.data.model.BodyToSend;
import com.example.exoplayertest.data.model.MediaObject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    //Registration
    @POST("index.php?p=showAllVideos")
    Observable<Response<MediaObject>> getFeed(@Body BodyToSend authBody);

}
