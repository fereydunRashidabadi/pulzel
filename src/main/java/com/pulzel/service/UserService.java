package com.pulzel.service;

import com.pulzel.dao.IUserDAO;
import com.pulzel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUser();
	}
	@Override
	public synchronized boolean addUser(User user){
       if (userDAO.userExists(user.getNational_code())) {
    	   return false;
       } else {
    	   userDAO.addUser(user);
    	   return true;
       }
	}

}
