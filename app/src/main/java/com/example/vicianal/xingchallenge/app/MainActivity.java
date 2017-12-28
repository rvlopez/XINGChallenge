package com.example.vicianal.xingchallenge.app;

import android.os.Bundle;

import com.example.vicianal.xingchallenge.R;
import com.example.vicianal.xingchallenge.app.di.component.ApplicationComponent;
import com.example.vicianal.xingchallenge.core.di.HasComponent;
import com.example.vicianal.xingchallenge.core.view.RootActivity;

public class MainActivity extends RootActivity implements HasComponent<ApplicationComponent> {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }

    @Override
    protected void initializeInjector() {

    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    protected void initializeRecycler() {

    }

    @Override
    public ApplicationComponent getComponent() {
        return null;
    }
}
