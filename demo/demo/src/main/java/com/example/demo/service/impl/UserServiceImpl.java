package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        User saveUser=userRepository.save(user);

        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        User user1=userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
        User updateUser=userRepository.save(user1);
        return updateUser;
    }

    @Override
    public User getSingleUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server" + userId));
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
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server" + userId));
        userRepository.delete(user);
    }
}
