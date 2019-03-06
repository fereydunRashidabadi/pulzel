package com.pulzel.service;

import com.pulzel.entity.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IUserService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<User> getAllUsers();
	 @Secured ({"ROLE_ADMIN"})
     boolean addUser(User user);

}
