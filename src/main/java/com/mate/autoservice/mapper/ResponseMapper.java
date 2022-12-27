package com.mate.autoservice.mapper;

public interface ResponseMapper<M, D> {
    D toDto(M model);
}
