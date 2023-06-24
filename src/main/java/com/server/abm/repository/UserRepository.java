package com.server.abm.repository;

import com.server.abm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserById(String id);

    User findUserByEmail(String email);

    User findUserByPhone(String phone);
}
