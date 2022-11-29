package com.mate.test.autoservice.mapper;

import com.mate.test.autoservice.dto.requestDto.CarRequestDto;
public interface RequestMapper<M, D> {
    M toModel(D dto);
}
