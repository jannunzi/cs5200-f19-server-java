package com.example.cs5200f19serverjava;

import com.example.cs5200f19serverjava.models.User;
import com.example.cs5200f19serverjava.repositories.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestUser {
    @Autowired
    UserRepository userRepository;
    @Test
    public void testFindAllUsers() {
//        List<User> users = (List<User>)
//                userRepository.findAll();
//        for(User user: users)
//            System.out.println(user.getFirstName());
    }

}
