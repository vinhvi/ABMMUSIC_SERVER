package com.server.abm.service;

import com.server.abm.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    List<Role> getAll();

    Role getByName(String name);

    Role getById(int id);
}
