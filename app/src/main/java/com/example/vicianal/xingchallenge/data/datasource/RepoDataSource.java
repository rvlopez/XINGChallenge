package com.example.vicianal.xingchallenge.data.datasource;

import com.example.vicianal.xingchallenge.data.datasource.mapper.RepoDtoMapper;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class RepoDataSource {

    private final RepoApi repoApi;
    private final RepoDtoMapper repoDtoMapper;

    @Inject public RepoDataSource(RepoApi repoApi, RepoDtoMapper repoDtoMapper) {
        this.repoApi = repoApi;
        this.repoDtoMapper = repoDtoMapper;
    }

    public Observable<List<RepoEntity>> getRepos() {
        return repoApi.getRepos().map(repoDtoMapper::toEntity);
    }
}
