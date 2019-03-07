package com.pulzel.service.impl;

import com.pulzel.dao.api.IUserDAO;
import com.pulzel.entity.User;
import com.pulzel.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public synchronized boolean addUser(User user) {
        if (userDAO.findByMobileNumber(user.getMobileNumber()) != null) {
            return false;
        } else {
            userDAO.save(user);
            return true;
        }
    }

}
