package com.example.room.di;

import android.app.Application;

import com.example.room.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;


@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,
                ViewModelModule.class

        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
     interface Build
    {
        @BindsInstance
        Build application(Application application);
        AppComponent buildAppComponent();
    }
}
