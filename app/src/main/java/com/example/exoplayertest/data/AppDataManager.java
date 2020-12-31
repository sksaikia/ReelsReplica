package com.example.exoplayertest.data;

import android.content.Context;


import com.example.exoplayertest.data.model.AuthBody;
import com.example.exoplayertest.data.model.MediaObject;
import com.example.exoplayertest.data.retrofit.AppApiHelper;
import com.example.exoplayertest.di.scopes.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

@Singleton
public class AppDataManager implements AppDataManagerHelper{

    private Context context;
    private AppApiHelper apiHelper;
    private static final String TAG = "AppDataManager";

    @Inject
    public AppDataManager(@ApplicationContext Context context, AppApiHelper apiHelper){
        this.context = context;
        this.apiHelper = apiHelper;
    }


    @Override
    public Observable<Response<MediaObject>> getFeed(AuthBody authBody) {
        return apiHelper.getFeed(authBody);
    }
}
