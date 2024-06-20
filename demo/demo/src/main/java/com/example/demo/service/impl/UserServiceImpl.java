package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        log.info("Initiating Service to create user");

        User saveUser=userRepository.save(user);
        log.info("Complete Service to create user");

        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        log.info("Initiating Service to update user");

        User user1=userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
        User updateUser=userRepository.save(user1);
        log.info("complete Service to update user");

        return updateUser;
    }

    @Override
    public User getSingleUser(Long userId) {
        log.info("Initiating Service to get single user");

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server" + userId));
        log.info("Complete  Service to get user");

        return user;
     /*
       Optional<User>user= userRepository.findById(userId);
       if (user.isPresent()){
           return user.get();
       }else{
           throw new NullPointerException("Resource not found on server" + userId);
       }
      */



    }

    @Override
    public List<User> getAllUsers() {
        log.info("Initiating Service to get All user");

        List<User> all = userRepository.findAll();
        log.info("Complete Service to get All user");

        return all;
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Initiating  Service to a  user");

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server" + userId));
        userRepository.delete(user);
        log.info("Complete Service to delete user");

    }
}
