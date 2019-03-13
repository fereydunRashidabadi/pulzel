package com.pulzel.service;

import com.pulzel.dao.IRolDAO;
import com.pulzel.entity.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolDAO rolDAO;

    @Override
    public List<AppRole> getAllRol() {
        return (List<AppRole>) rolDAO.findAll();
    }
}
