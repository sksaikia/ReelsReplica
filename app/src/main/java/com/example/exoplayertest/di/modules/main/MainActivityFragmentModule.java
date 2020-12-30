package com.example.exoplayertest.di.modules.main;

import com.example.exoplayertest.ui.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract HomeFragment bindDemoHomeFragment();



}
