package com.pulzel.service;

import com.pulzel.dao.IUserDAO;
import com.pulzel.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService implements IUserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IUserDAO UserDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<AppUser> getAllUsers() {
        return (List<AppUser>) UserDAO.findAll();
    }

    @Override
    public void updateUser(String mobileNumber ,AppUser user) {
        AppUser appUser = UserDAO.findByMobileNumber(mobileNumber);
        appUser.setUserName(appUser.getUserName());
        appUser.setNational_code(appUser.getNational_code());
        appUser.setCard_number(appUser.getCard_number());
        appUser.setMobileNumber(appUser.getMobileNumber());
        appUser.setEncrytedPassword(passwordEncoder.encode(user.getEncrytedPassword()));


    }

    @Override
    public void saveUser(AppUser appUser) {

        AppUser appUsers = UserDAO.findByMobileNumber(appUser.getMobileNumber());
        if (appUser == null) {
            System.out.println("User not found! " + appUser.getMobileNumber());
            throw new UsernameNotFoundException("User " + appUser.getMobileNumber() + "mojod ast");
        } else {
            appUser.setEncrytedPassword(passwordEncoder.encode(appUser.getEncrytedPassword()));
            UserDAO.save(appUser);
        }
    }

    public void deleteUser(String mobileNumber) {
        UserDAO.deleteAppUserByMobileNumber(mobileNumber);
    }


}
