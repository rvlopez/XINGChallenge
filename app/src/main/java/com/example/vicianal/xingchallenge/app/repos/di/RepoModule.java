package com.example.vicianal.xingchallenge.app.repos.di;

import com.example.vicianal.xingchallenge.app.repos.presenter.RepoPresenter;
import com.example.vicianal.xingchallenge.app.repos.usecase.RepoUseCase;
import com.example.vicianal.xingchallenge.core.interactor.Interactor;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoModule {

    @Provides public Interactor<List<RepoEntity>> provideRepoUseCase(RepoUseCase repoUseCase) {
        return repoUseCase;
    }

    @Provides public RepoPresenter provideRepoPresenter(RepoUseCase repoUseCase) {
        return new RepoPresenter(repoUseCase);
    }
}
