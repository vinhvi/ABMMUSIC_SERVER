package com.server.abm.service;

import com.server.abm.entity.Type;

public interface TypeService {
    Type crate(Type type);
    Type getByName(String name);
}
