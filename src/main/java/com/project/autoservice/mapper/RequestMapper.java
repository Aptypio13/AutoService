package com.project.autoservice.mapper;

public interface RequestMapper<M, D> {
    M toModel(D dto);
}
