package com.example.vicianal.xingchallenge.app.repos.di;

import com.example.vicianal.xingchallenge.app.repos.view.RepoActivity;

import dagger.Subcomponent;

@Subcomponent(modules = RepoModule.class)
public interface RepoComponent {
    void inject(RepoActivity activity);
}
