package com.example.vicianal.xingchallenge.app.repos.presenter;

import com.example.vicianal.xingchallenge.app.repos.usecase.RepoUseCase;
import com.example.vicianal.xingchallenge.app.repos.view.RepoView;
import com.example.vicianal.xingchallenge.core.interactor.Interactor;
import com.example.vicianal.xingchallenge.core.presenter.Presenter;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

public class RepoPresenter extends Presenter<RepoView> {

    private RepoUseCase repoUseCase;

    public RepoPresenter(Interactor<List<RepoEntity>> repoUseCase) {
        this.repoUseCase = (RepoUseCase) repoUseCase;
    }

    @Override
    protected void initialize() {

    }

    @Override
    public void stop() {
        repoUseCase.unsubscribe();
    }
}
