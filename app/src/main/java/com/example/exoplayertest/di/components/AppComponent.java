package com.example.exoplayertest.di.components;

import android.app.Application;

import com.example.exoplayertest.base.BaseApplication;
import com.example.exoplayertest.di.modules.app.ActivityBuildersModule;
import com.example.exoplayertest.di.modules.app.AppModule;
import com.example.exoplayertest.di.modules.app.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = { ActivityBuildersModule.class
        , AndroidInjectionModule.class,
        AppModule.class, RetrofitModule.class})
public interface AppComponent {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }

}
