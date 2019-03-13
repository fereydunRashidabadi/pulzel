package com.pulzel.dao;

import com.pulzel.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserDAO extends PagingAndSortingRepository<AppUser, Long> {

    AppUser findByMobileNumber(String mobileNumber);

    List<AppUser> deleteAppUserByMobileNumber(String mobileNumber);

    @Query(nativeQuery = true, value = "select aa.ROLE_NAME from (SELECT au.USER_ID,\n" +
            "  au.USER_NAME,\n" +
            "  ur.ROLE_ID\n" +
            "FROM USER_ROLE ur\n" +
            "INNER JOIN APP_USER au\n" +
            "ON au.USER_ID    = ur.USER_ID\n" +
            "WHERE au.USER_ID = :userId)\n" +
            "rol \n" +
            "INNER JOIN APP_ROLE aa on aa.ROLE_ID = rol.ROLE_ID")
    List<String> findByRolUser(@Param("userId") Long userId);


}
