package com.pulzel.service;

import com.pulzel.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> getAllCompanis();
    void save(Company company);
}
