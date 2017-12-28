package com.example.vicianal.xingchallenge.app.repos.usecase;

import com.example.vicianal.xingchallenge.core.executor.MainThread;
import com.example.vicianal.xingchallenge.core.interactor.Interactor;
import com.example.vicianal.xingchallenge.data.repository.RepoRepository;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

public class RepoUseCase extends Interactor<List<RepoEntity>> {

    private final RepoRepository repoRepository;

    @Inject public RepoUseCase(Executor executor, MainThread mainThread, RepoRepository repoRepository) {
        super(executor, mainThread);

        if (repoRepository == null) {
            throw new IllegalArgumentException("RepoRepository must have valid parameters");
        }

        this.repoRepository = repoRepository;
    }

    public void execute(Subscriber<List<RepoEntity>> subscriber) {
        super.execute(subscriber);
    }

    @Override
    protected Observable<List<RepoEntity>> buildObservable() {
        return repoRepository.getRepos();
    }
}
