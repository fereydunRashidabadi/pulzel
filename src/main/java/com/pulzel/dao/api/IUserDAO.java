package com.pulzel.dao.api;

import com.pulzel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IUserDAO extends JpaRepository<User, Integer> {

    User findByMobileNumber(String mobileNumber);
}