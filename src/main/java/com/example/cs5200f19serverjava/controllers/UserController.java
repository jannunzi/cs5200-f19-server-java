package com.example.cs5200f19serverjava.controllers;

import com.example.cs5200f19serverjava.models.User;
import com.example.cs5200f19serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;
    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return (List<User>)repository.findAll();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    @GetMapping("/api/username/{username}")
    public User findUserByUsername(
            @PathVariable("username") String username) {
        User alice = repository.findUserByUsername(username);
        return alice;
    }

    @GetMapping("/api/credentials/{username}/{password}")
    public User findUserByCredentials(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {
        User alice = repository.findUserByCredentials(username, password);
        return alice;
    }

    @GetMapping("/api/create/{username}/{password}/{first}/{last}")
    public User createUser(
            @PathVariable("first") String firstName,
            @PathVariable("last") String lastName,
            @PathVariable("username") String username,
            @PathVariable("password") String password
    ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user = repository.save(user);
        return user;
    }



    @GetMapping("/api/update/{userId}/{first}/{last}")
    public User updateUser(
            @PathVariable("first") String firstName,
            @PathVariable("last") String lastName,
            @PathVariable("userId") int id
    ) {
        User user = repository.findById(id).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user = repository.save(user);
        return user;
    }

    @GetMapping("/api/delete/{userId}")
    public List<User> updateUser(
            @PathVariable("userId") int id
    ) {
        repository.deleteById(id);
        return (List<User>)repository.findAll();
    }

}
