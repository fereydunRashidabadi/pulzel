package com.pulzel.controller;

import com.pulzel.entity.AppRole;
import com.pulzel.entity.Company;
import com.pulzel.service.ICompanyService;
import com.pulzel.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getAllCompanis() {
        List<Company> list = companyService.getAllCompanis();
        return new ResponseEntity<List<Company>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/newCompany", method =  RequestMethod.POST)
    public ResponseEntity<Void> addCompany(@RequestBody Company company, UriComponentsBuilder builder) {
        companyService.save(company);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
