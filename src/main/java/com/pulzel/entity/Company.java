package com.pulzel.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_COMPANY",
        uniqueConstraints = {
                @UniqueConstraint(name = "COMPANY_UK", columnNames = "COMPANY_NAME")})
@Data
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "COMPANY_Name", length = 36, nullable = false)
    private String companyName;

    @Column(name = "tel_number", length = 15, nullable = false)
    private String telNumber;

    @Column(name = "address" , length = 500, nullable = false)
    private String address;

}
