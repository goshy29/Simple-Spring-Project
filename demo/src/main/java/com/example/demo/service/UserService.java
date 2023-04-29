package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    @Qualifier("fromMySQL")
    private final UserDao userDao;

    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    public Users saveUser(Users users) {
        return userDao.saveUser(users);
    }

    public Users getUserById(int id) {
        return userDao.getUserById(id);
    }

    public Users updateUser(Users users) {
        return userDao.updateUser(users);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
