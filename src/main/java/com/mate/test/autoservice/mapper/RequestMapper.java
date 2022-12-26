package com.mate.test.autoservice.mapper;

public interface RequestMapper<M, D> {
    M toModel(D dto);
}
