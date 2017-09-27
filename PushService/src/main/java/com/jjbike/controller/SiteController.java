package com.jjbike.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SiteController {

    @ApiIgnore
    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "Hello world");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam(value = "user_name") String userName, @RequestParam(value = "user_password") String userPassword){
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userPassword", userPassword);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
