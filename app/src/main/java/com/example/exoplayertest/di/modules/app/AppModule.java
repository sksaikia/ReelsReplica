package com.example.exoplayertest.di.modules.app;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;


import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.exoplayertest.R;
import com.example.exoplayertest.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    @ApplicationContext
    abstract Context provideContext(Application application);


    @Provides
    @Singleton
    static RequestOptions provideRequestOptions(){
        return RequestOptions.placeholderOf(R.drawable.ic_launcher_background).
                error(R.drawable.ic_launcher_background);
    }

    @Provides
    @Singleton
    static Drawable provideAppDrawable(Application application){
        return ContextCompat.getDrawable(application,
                R.drawable.ic_launcher_background);
    }

    @Provides
    @Singleton
    static RequestManager provideGlideInstance(Application application,
                                               RequestOptions requestOptions){
        return Glide.with(application).setDefaultRequestOptions(requestOptions);
    }


}
