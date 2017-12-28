package com.example.vicianal.xingchallenge.app.repos.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vicianal.xingchallenge.R;
import com.example.vicianal.xingchallenge.RepoApplication;
import com.example.vicianal.xingchallenge.app.di.component.ApplicationComponent;
import com.example.vicianal.xingchallenge.app.repos.adapter.RepoAdapter;
import com.example.vicianal.xingchallenge.app.repos.di.RepoComponent;
import com.example.vicianal.xingchallenge.app.repos.di.RepoModule;
import com.example.vicianal.xingchallenge.app.repos.presenter.RepoPresenter;
import com.example.vicianal.xingchallenge.core.di.HasComponent;
import com.example.vicianal.xingchallenge.core.view.RootActivity;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class RepoActivity extends RootActivity implements RepoView, HasComponent<RepoComponent> {

    private RepoComponent repoComponent;

    @Inject RepoPresenter repoPresenter;
    @Inject RepoAdapter repoAdapter;

    @BindView(R.id.showNoResults) TextView showNoResults;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ContentLoadingProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showData(List<RepoEntity> repos) {
        recyclerView.setVisibility(View.VISIBLE);
        repoAdapter.setItems(repos);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        showNoResults.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        showNoResults.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        showNoResults.setText(R.string.error_message);
        showNoResults.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showNoResults() {
        showNoResults.setText(R.string.no_results_message);
        showNoResults.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_repo;
    }

    @Override
    protected void initializeInjector() {
        repoComponent = ((RepoApplication) getApplication())
                .getComponent().repoComponent(new RepoModule());
        repoComponent.inject(this);

    }

    @Override
    protected void initializePresenter() {
        repoPresenter.loadRepos();
    }

    @Override
    protected void initializeRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(repoAdapter);
    }

    @Override
    public RepoComponent getComponent() {
        return repoComponent;
    }
}
