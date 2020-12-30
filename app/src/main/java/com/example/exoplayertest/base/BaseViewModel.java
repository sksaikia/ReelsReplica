package com.example.exoplayertest.base;

import android.app.Application;

import androidx.lifecycle.ViewModel;


import com.example.exoplayertest.data.AppDataManager;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;
      private AppDataManager dataManager;

    public BaseViewModel(AppDataManager appDataManager, Application application){
        this.dataManager = appDataManager;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        compositeDisposable.dispose();
        compositeDisposable.clear();

    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}

