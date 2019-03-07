package com.pulzel.config;

import com.pulzel.dao.api.IUserDAO;
import com.pulzel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String mobileNumber)
            throws UsernameNotFoundException {
        User activeUser = userDAO.findByMobileNumber(mobileNumber);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUser.getRole());
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(activeUser.getUserName(),
                activeUser.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}

