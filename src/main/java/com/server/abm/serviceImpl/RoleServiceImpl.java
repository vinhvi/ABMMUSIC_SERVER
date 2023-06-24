package com.server.abm.serviceImpl;

import com.server.abm.entity.Role;
import com.server.abm.repository.RoleRepository;
import com.server.abm.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role getById(int id) {
        return roleRepository.findRoleById(id);
    }
}
