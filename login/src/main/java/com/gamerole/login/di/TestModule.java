package com.gamerole.login.di;

import com.gamerole.login.service.HttpService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class TestModule {
    @Provides
    @Singleton
    public HttpService provideHttpService() {
        return new HttpService();
    }

}
