package com.server.abm.serviceImpl;

import com.server.abm.entity.Type;
import com.server.abm.repository.TypeRepository;
import com.server.abm.service.TypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public Type crate(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getByName(String name) {
        return typeRepository.findTypeByName(name);
    }
}
