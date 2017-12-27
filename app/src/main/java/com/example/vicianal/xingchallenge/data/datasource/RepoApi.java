package com.example.vicianal.xingchallenge.data.datasource;

import com.example.vicianal.xingchallenge.data.datasource.dto.RepoResponseDto;

import retrofit2.http.GET;
import rx.Observable;

public interface RepoApi {

    String BASE_URL = "https://api.github.com/users/xing/repos";

    @GET(BASE_URL)
    Observable<RepoResponseDto> getRepos();
}
