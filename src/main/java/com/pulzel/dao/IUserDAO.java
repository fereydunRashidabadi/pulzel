package com.pulzel.dao;

import com.pulzel.entity.User;

import java.util.List;

public interface IUserDAO {
    User getActiveUser(String userName);

    void addUser(User user);

    boolean userExists(String national_code);

    List<User> getAllUser();
}