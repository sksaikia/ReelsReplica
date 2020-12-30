package com.example.exoplayertest.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.exoplayertest.data.AppDataManager;


public class ViewModelFactory<T> implements ViewModelProvider.Factory {

    private T viewModel;
  private AppDataManager appDataManager;
    private Application application;

    public ViewModelFactory(T viewModel, AppDataManager appDataManager, Application application) {
        this.viewModel = viewModel;
        this.appDataManager = appDataManager;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }



}

