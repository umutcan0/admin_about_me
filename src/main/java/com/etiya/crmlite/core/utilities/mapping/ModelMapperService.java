package com.etiya.crmlite.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();

    ModelMapper forResponse();
}
