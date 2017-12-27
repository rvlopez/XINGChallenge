package com.example.vicianal.xingchallenge.app.repos.view;

import com.example.vicianal.xingchallenge.core.view.IView;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

public interface RepoView extends IView {

    void showData(List<RepoEntity> repos);

    void showProgress();

    void hideProgress();

    void showError();

    void showNoResults();
}
