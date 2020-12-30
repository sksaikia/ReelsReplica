package com.example.exoplayertest.data.retrofit;

import com.example.exoplayertest.data.model.BodyToSend;
import com.example.exoplayertest.data.model.MediaObject;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppApiHelper implements APIInterface{

    APIInterface api;

    @Inject
    public AppApiHelper(Retrofit retrofit) {
        api = retrofit.create(APIInterface.class);
    }


    @Override
    public Observable<Response<MediaObject>> getFeed(BodyToSend authBody) {
        return api.getFeed(authBody);
    }
}
