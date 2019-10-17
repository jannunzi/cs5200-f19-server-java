package com.example.cs5200f19serverjava.repositories;

import com.example.cs5200f19serverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository
    extends CrudRepository<User, Integer> {
//    @Query(value = "SELECT * FROM users WHERE users.username=:username", nativeQuery = true)
    @Query("SELECT user FROM User user WHERE user.username=:username")
    public User findUserByUsername(
            @Param("username") String username);
//    @Query(value = "SELECT * FROM users WHERE users.username=:username AND users.password=:password", nativeQuery = true)
    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public User findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password);
}
