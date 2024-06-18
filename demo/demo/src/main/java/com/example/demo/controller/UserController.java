package com.example.demo.controller;

import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
private UserServiceI userServiceI;
}
