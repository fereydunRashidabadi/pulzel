package com.pulzel.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state")
    private State state;

    @Column(name = "enabled")
    private short enabled;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "national_code")
    private String national_code;

}
