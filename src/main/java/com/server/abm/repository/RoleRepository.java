package com.server.abm.repository;

import com.server.abm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleById(int id);

    Role findRoleByName(String name);
}
