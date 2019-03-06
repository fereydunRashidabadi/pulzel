package com.pulzel.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pulzel.dao.IUserDAO;
import com.pulzel.entity.User;
@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User activeUser = userDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUser.getRole());
		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUser.getUserName(),
				activeUser.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}

