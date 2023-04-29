package com.example.demo.dao;

import com.example.demo.model.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserDao {
    List<Users> getAllUsers();

    Users saveUser(Users users);

    Users getUserById(int id);

    Users updateUser(Users users);

    void deleteUserById(int id);
}
