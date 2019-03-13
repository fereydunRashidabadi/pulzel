package com.pulzel.controller;

import com.pulzel.entity.AppRole;
import com.pulzel.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class RolController {

    @Autowired
    private IRolService rolService;

    @RequestMapping(value = "/rolGet", method = RequestMethod.GET)
    public ResponseEntity<List<AppRole>> getAllRol() {
        List<AppRole> list = rolService.getAllRol();
        return new ResponseEntity<List<AppRole>>(list, HttpStatus.OK);
    }

}
