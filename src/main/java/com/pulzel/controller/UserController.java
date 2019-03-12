package com.pulzel.controller;

import com.pulzel.entity.AppUser;
import com.pulzel.service.IRolService;
import com.pulzel.service.IUserService;
import com.pulzel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    private IUserService iUserService;


    @RequestMapping(value = "/userGet", method = RequestMethod.GET)
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> list = iUserService.getAllUsers();
        return new ResponseEntity<List<AppUser>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody AppUser appUser, UriComponentsBuilder builder) {
        iUserService.saveUser(appUser);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/userUpdate/{mobileNumber}", method = RequestMethod.POST)
    public ResponseEntity<Void> updateUser(@PathVariable("mobileNumber") String mobileNumber,@RequestBody AppUser appUser, UriComponentsBuilder builder) {
        iUserService.updateUser(mobileNumber,appUser);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{mobileNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("mobileNumber") String mobileNumber, UriComponentsBuilder builder) {
        iUserService.deleteUser(mobileNumber);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
