package com.example.exoplayertest.ui;


import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.exoplayertest.base.BaseViewModel;
import com.example.exoplayertest.data.AppDataManager;
import com.example.exoplayertest.data.model.AuthBody;
import com.example.exoplayertest.data.model.MainResponseBody;
import com.example.exoplayertest.data.model.MediaObject;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainViewModel extends BaseViewModel {

    private AppDataManager appDataManager;

    private MutableLiveData<ArrayList<MainResponseBody>> allData;

    private static final String TAG = "TestHere";

    public LiveData<ArrayList<MainResponseBody>> getAllData(){
        if (allData==null)
            allData = new MutableLiveData<java.util.ArrayList<com.example.exoplayertest.data.model.MainResponseBody>>();
        return allData;
    }


    @Inject
    public MainViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);
        this.appDataManager = appDataManager;
    }


    public void getData(AuthBody authBody){


        Log.d(TAG, "getData: Got here");

        if (allData==null)
            allData = new MutableLiveData<java.util.ArrayList<com.example.exoplayertest.data.model.MainResponseBody>>();

        appDataManager.getFeed(authBody).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<MediaObject>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(@NonNull Response<MediaObject> mediaObjectResponse) {

                        Log.d(TAG, "onNext: " + mediaObjectResponse.code());
                        allData.setValue(mediaObjectResponse.body().getList());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: eeror" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
