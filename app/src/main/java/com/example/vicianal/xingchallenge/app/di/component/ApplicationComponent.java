package com.example.vicianal.xingchallenge.app.di.component;

import com.example.vicianal.xingchallenge.RepoApplication;
import com.example.vicianal.xingchallenge.app.di.module.ApplicationModule;
import com.example.vicianal.xingchallenge.app.repos.di.RepoComponent;
import com.example.vicianal.xingchallenge.app.repos.di.RepoModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(RepoApplication application);

    // Sub-components
    RepoComponent repoComponent(RepoModule module);
}
