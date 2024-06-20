package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    @Autowired
private UserServiceI userServiceI;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
   log.info("Initiating request to create user");
        User user1 = userServiceI.createUser(user);
        log.info("Complete request to create user");

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<User>>getAllUser(){
    log.info("Initiating request to get All user");
    List<User> allUsers = userServiceI.getAllUsers();
    log.info("Complete request to get All user");

    return new ResponseEntity<>(allUsers,HttpStatus.OK);
}
@GetMapping("/users/{userId}")
public ResponseEntity<User> getSingleUser(@PathVariable Long userId) {
    log.info("Initiating request to get Single user");

    User user = userServiceI.getSingleUser(userId);
    log.info("Complete request to get Single user");

    return new ResponseEntity<>(user, HttpStatus.OK);
}
@PutMapping("/users/{userId}")
public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable Long userId){
    log.info("Initiating request to update user");

    User user1 = userServiceI.updateUser(user,userId);
    log.info("Complete request to update user");

    return new ResponseEntity<>(user1, HttpStatus.CREATED);

}
public ResponseEntity<String>deleteUser(@PathVariable Long userId){
    log.info("Initiating request to delete user");

    userServiceI.deleteUser(userId);
    log.info("Complete  request to delete user");

    return new ResponseEntity<>("Resource Delete Successful !!",HttpStatus.OK);

}

}
