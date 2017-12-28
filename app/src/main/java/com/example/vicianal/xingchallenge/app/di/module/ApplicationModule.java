package com.example.vicianal.xingchallenge.app.di.module;

import android.content.Context;

import com.example.vicianal.xingchallenge.RepoApplication;
import com.example.vicianal.xingchallenge.app.repos.presenter.RepoPresenter;
import com.example.vicianal.xingchallenge.app.repos.usecase.RepoUseCase;
import com.example.vicianal.xingchallenge.core.executor.MainThread;
import com.example.vicianal.xingchallenge.core.executor.ThreadExecutor;
import com.example.vicianal.xingchallenge.core.interactor.Interactor;
import com.example.vicianal.xingchallenge.data.ServiceFactory;
import com.example.vicianal.xingchallenge.data.datasource.RepoApi;
import com.example.vicianal.xingchallenge.data.datasource.RepoApiConstants;
import com.example.vicianal.xingchallenge.data.datasource.RepoDataSource;
import com.example.vicianal.xingchallenge.data.repository.RepoRepository;
import com.example.vicianal.xingchallenge.data.repository.RepoRepositoryImpl;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context applicationContext;

    public ApplicationModule(RepoApplication applicationContext) {
        this.applicationContext = applicationContext.getApplicationContext();
    }

    @Provides @Singleton
    public Executor provideExecutor() {
        return new ThreadExecutor();
    }

    @Provides @Singleton
    public MainThread providesMainThread() {
        return new MainThread();
    }

    @Provides @Singleton
    public RepoRepository provideRepoRepository(RepoDataSource repoDataSource) {
        return new RepoRepositoryImpl(repoDataSource);
    }

    @Provides @Singleton
    public RepoApi provideRepoApi() {
        return ServiceFactory.createRetrofitService(RepoApi.class, RepoApiConstants.BASE_URL);
    }

    @Provides @Singleton
    public Context provideApplicationContext() {
        return applicationContext;
    }
}
