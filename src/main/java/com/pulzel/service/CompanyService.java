package com.pulzel.service;

import com.pulzel.dao.ICompanyDAO;
import com.pulzel.dao.IRolDAO;
import com.pulzel.entity.AppRole;
import com.pulzel.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyDAO companyDAO;

    @Override
    public List<Company> getAllCompanis() {
        return (List<Company>) companyDAO.findAll();
    }

    @Override
    public void save(Company company) {
        companyDAO.save(company);
    }
}
