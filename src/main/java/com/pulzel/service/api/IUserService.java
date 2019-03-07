package com.pulzel.service.api;

import com.pulzel.entity.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IUserService {

     List<User> getAllUsers();

     boolean addUser(User user);

}
