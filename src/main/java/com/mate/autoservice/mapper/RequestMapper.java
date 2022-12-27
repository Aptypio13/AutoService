package com.mate.autoservice.mapper;

public interface RequestMapper<M, D> {
    M toModel(D dto);
}
