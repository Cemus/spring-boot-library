package com.kev.springrest.controller;

import com.kev.springrest.exception.UserNotFoundException;
import com.kev.springrest.model.User;
import com.kev.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> findAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUserById(@PathVariable Long id){
        return Optional.ofNullable(userService.getUser(id).orElseThrow(
                () -> new UserNotFoundException(id)));
    }

}
