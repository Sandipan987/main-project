package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
private UserServiceI userServiceI;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userServiceI.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<User>>getAllUser(){
    List<User> allUsers = userServiceI.getAllUsers();
    return new ResponseEntity<>(allUsers,HttpStatus.OK);
}
@GetMapping("/users/{userId}")
public ResponseEntity<User> getSingleUser(@PathVariable Long userId) {
    User user = userServiceI.getSingleUser(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
}
@PutMapping("/users/{userId}")
public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable Long userId){
    User user1 = userServiceI.updateUser(user,userId);
    return new ResponseEntity<>(user1, HttpStatus.CREATED);

}
public ResponseEntity<String>deleteUser(@PathVariable Long userId){
    userServiceI.deleteUser(userId);
    return new ResponseEntity<>("Resource Delete Successful !!",HttpStatus.OK);

}

}
