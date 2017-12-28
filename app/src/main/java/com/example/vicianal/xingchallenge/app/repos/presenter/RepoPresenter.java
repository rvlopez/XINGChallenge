package com.example.vicianal.xingchallenge.app.repos.presenter;

import com.example.vicianal.xingchallenge.app.repos.usecase.RepoUseCase;
import com.example.vicianal.xingchallenge.app.repos.view.RepoView;
import com.example.vicianal.xingchallenge.core.interactor.Interactor;
import com.example.vicianal.xingchallenge.core.presenter.Presenter;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class RepoPresenter extends Presenter<RepoView> {

    private RepoUseCase repoUseCase;

    public RepoPresenter(Interactor<List<RepoEntity>> repoUseCase) {
        this.repoUseCase = (RepoUseCase) repoUseCase;
    }

    @Override
    protected void initialize() {

    }

    public void loadRepos() {
        view.showProgress();

        repoUseCase.execute(new Subscriber<List<RepoEntity>>() {
            List<RepoEntity> repoList = new ArrayList<>();

            @Override
            public void onCompleted() {
                view.hideProgress();
                if (repoList.isEmpty()) {
                    view.showNoResults();
                } else {
                    view.showData(repoList);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<RepoEntity> repoEntities) {
                repoList.addAll(repoEntities);
            }
        });
    }

    @Override
    public void stop() {
        repoUseCase.unsubscribe();
    }
}
