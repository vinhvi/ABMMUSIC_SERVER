package com.server.abm.repository;

import com.server.abm.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
    Type findTypeByName(String name);
}
