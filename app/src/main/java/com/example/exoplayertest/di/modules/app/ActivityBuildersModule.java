package com.example.exoplayertest.di.modules.app;


import com.example.exoplayertest.di.modules.main.MainActivityFragmentModule;
import com.example.exoplayertest.di.modules.main.MainActivityModule;
import com.example.exoplayertest.di.scopes.PerActivity;
import com.example.exoplayertest.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, MainActivityFragmentModule.class})
    @PerActivity
    abstract MainActivity bindMainActivity();



}
