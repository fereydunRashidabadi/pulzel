package com.pulzel.controller;

import com.pulzel.entity.Advertis;
import com.pulzel.service.api.IAdvertisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("user")
public class AdvertisController {
    @Autowired
    private IAdvertisService advertisService;

    @GetMapping("advertis/{id}")
    public ResponseEntity<Advertis> getAdvertisById(@PathVariable("id") Integer id) {
        Advertis advertis = advertisService.getAdvertisById(id);
        return new ResponseEntity<Advertis>(advertis, HttpStatus.OK);
    }

    @GetMapping("advertises")
    public ResponseEntity<List<Advertis>> getAllAdvertises() {
        List<Advertis> list = advertisService.getAllAdvertises();
        return new ResponseEntity<List<Advertis>>(list, HttpStatus.OK);
    }

    @PostMapping("advertis")
    public ResponseEntity<Void> addAdvertis(@RequestBody Advertis advertis, UriComponentsBuilder builder) {
        boolean flag = advertisService.addAdvertis(advertis);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/advertis/{id}").buildAndExpand(advertis.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("advertis")
    public ResponseEntity<Advertis> updateAdvertis(@RequestBody Advertis advertis) {
        advertisService.updateAdvertis(advertis);
        return new ResponseEntity<Advertis>(advertis, HttpStatus.OK);
    }

    @DeleteMapping("advertis/{id}")
    public ResponseEntity<Void> deleteAdvertis(@PathVariable("id") Integer id) {
        advertisService.deleteAdvertis(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
} 