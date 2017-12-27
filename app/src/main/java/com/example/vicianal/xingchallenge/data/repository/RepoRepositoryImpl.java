package com.example.vicianal.xingchallenge.data.repository;

import com.example.vicianal.xingchallenge.data.datasource.RepoDataSource;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RepoRepositoryImpl implements RepoRepository {

    private final RepoDataSource repoDataSource;

    @Inject public RepoRepositoryImpl(RepoDataSource repoDataSource) {
        if (repoDataSource == null) {
            throw new IllegalArgumentException("RepoRepository parameters can't be null");
        }
        this.repoDataSource = repoDataSource;
    }

    @Override
    public Observable<List<RepoEntity>> getRepos() {
        return Observable.concat(repoDataSource.getRepos()
                .onErrorResumeNext(Observable.empty()).subscribeOn(Schedulers.io()));
    }
}
