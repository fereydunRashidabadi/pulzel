package com.pulzel.service;

import com.pulzel.entity.AppUser;

import java.util.List;

public interface IUserService {

    List<AppUser> getAllUsers();

    void saveUser(AppUser appUser);

    void updateUser(String mobileNumber , AppUser appUser);

    void deleteUser(String mobileNumber);

}
