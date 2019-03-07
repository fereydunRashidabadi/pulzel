package com.pulzel.dao.impl;

import com.pulzel.dao.api.IUserDAO;
import com.pulzel.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public abstract class UserDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public User findByMobileNumber(String mobileNumber) {
        String hql = "FROM User where mobile_number = ?";
        User user = (User) entityManager.createQuery(hql).setParameter(1, mobileNumber).getSingleResult();
        return user;

    }
}
