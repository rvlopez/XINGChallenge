package com.example.vicianal.xingchallenge.data.datasource;

import com.example.vicianal.xingchallenge.data.datasource.dto.RepoResponseDto;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface RepoApi {

    @GET(RepoApiConstants.BASE_URL)
    Observable<List<RepoResponseDto>> getRepos();
}
