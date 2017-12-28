package com.example.vicianal.xingchallenge.data.datasource.mapper;

import com.example.vicianal.xingchallenge.data.datasource.dto.OwnerDto;
import com.example.vicianal.xingchallenge.data.datasource.dto.RepoResponseDto;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RepoDtoMapper {

    @Inject public RepoDtoMapper() {
    }

    public List<RepoEntity> toEntity(List<RepoResponseDto> repoResponseDtoList) {
        List<RepoEntity> repos = new ArrayList<>();
        if (repoResponseDtoList.size() > 0) {
            for (RepoResponseDto repoResponseDto : repoResponseDtoList) {
                RepoEntity repoEntity = new RepoEntity();
                if (repoResponseDto != null) {
                    repoEntity.setId(repoResponseDto.getId());
                    repoEntity.setName(repoResponseDto.getName());
                    repoEntity.setFullName(repoResponseDto.getFullName());
                    repoEntity.setOwner(toOwner(repoResponseDto.getOwner()));
                    repoEntity.setFork(repoResponseDto.isFork());
                    repoEntity.setDescription(repoResponseDto.getDescription());
                    repoEntity.setHtmlUrl(repoResponseDto.getHtmlUrl());
                }
                repos.add(repoEntity);
            }
        }
        return repos;
    }

    private OwnerDto toOwner(OwnerDto ownerDto) {
        OwnerDto owner = new OwnerDto();
        if (ownerDto != null) {
            owner.setId(ownerDto.getId());
            owner.setLogin(ownerDto.getLogin());
            owner.setHtmlUrl(ownerDto.getHtmlUrl());
        }
        return owner;
    }
}
