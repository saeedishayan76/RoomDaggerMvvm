package com.example.room.di;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String getString()
    {
        return
                "Hello Shayan";
    }

}
