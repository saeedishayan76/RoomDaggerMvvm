package com.example.room.di;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.room.viewmodel.WordViewModel;

import java.util.Map;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {
    @Provides
    static ViewModelProvider.Factory provideFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators)
    {
        return new ViewModelProviderFactory(creators);
    }

    @Provides
    @IntoMap
    @ViewModelKey(WordViewModel.class)
    static ViewModel provideWordViewModel(Application application)
    {
        return new WordViewModel(application);
    }
}
