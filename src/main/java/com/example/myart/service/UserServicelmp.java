package com.example.myart.service;

import com.example.myart.dao.UserDao;
import com.example.myart.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServicelmp implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServicelmp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void creatUser(Users users) {
        userDao.creatUser(users);
    }

    @Transactional
    @Override
    public void updatUser(Users users) {
        userDao.updatUser(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Users getUserId(Long id) {
        return userDao.getUserId(id);
    }

    @Transactional
    @Override
    public void delUser(Long id) {
        userDao.delUser(id);
    }
}