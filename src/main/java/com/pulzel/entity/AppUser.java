package com.pulzel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "App_User",
        uniqueConstraints = {
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "mobile_number")})
@Data
public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "national_code")
    private String national_code;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
}
