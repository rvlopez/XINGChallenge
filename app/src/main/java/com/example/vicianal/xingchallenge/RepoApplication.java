package com.example.vicianal.xingchallenge;

import android.app.Application;
import com.example.vicianal.xingchallenge.app.di.component.ApplicationComponent;
import com.example.vicianal.xingchallenge.app.di.module.ApplicationModule;
import com.example.vicianal.xingchallenge.core.di.HasComponent;

public class RepoApplication extends Application implements HasComponent<ApplicationComponent> {

    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public void setComponent(ApplicationComponent component) {
        this.applicationComponent = component;
    }

    @Override
    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
