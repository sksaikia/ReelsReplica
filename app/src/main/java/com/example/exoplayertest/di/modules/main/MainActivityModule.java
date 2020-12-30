package com.example.exoplayertest.di.modules.main;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ViewModelProviders;


import com.example.exoplayertest.base.ViewModelFactory;
import com.example.exoplayertest.data.AppDataManager;
import com.example.exoplayertest.di.scopes.ActivityContext;
import com.example.exoplayertest.di.scopes.PerActivity;
import com.example.exoplayertest.ui.MainActivity;
import com.example.exoplayertest.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Provides
    @PerActivity
    @ActivityContext
    static Context provideMainActivityModule(MainActivity activity){
        return activity;
    }


    @Provides
    @PerActivity
    static MainViewModel provideMainViewModel(@ActivityContext Context context, Application application, AppDataManager appDataManager){
        MainViewModel vm = new MainViewModel(appDataManager, application);
        ViewModelFactory<MainViewModel> factory = new ViewModelFactory<>(vm,appDataManager,application);
        return ViewModelProviders.of((MainActivity) context,factory).get(MainViewModel.class);
    }
}
