package com.server.abm.service;

import com.server.abm.entity.User;

import java.util.List;

public interface UserService {
    User saveOrUpdate( User user);
    List<User> getAllUser();
    User getById(String id);
    User getByEmail(String email);
    User getByPhone(String phone);
    String randomId();


}
