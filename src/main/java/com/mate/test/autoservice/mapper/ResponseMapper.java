package com.mate.test.autoservice.mapper;

public interface ResponseMapper<M, D> {
    D toDto(M model);
}
