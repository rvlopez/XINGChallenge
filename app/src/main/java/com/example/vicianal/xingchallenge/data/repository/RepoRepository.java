package com.example.vicianal.xingchallenge.data.repository;

import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import rx.Observable;

public interface RepoRepository {

    Observable<List<RepoEntity>> getRepos();
}
