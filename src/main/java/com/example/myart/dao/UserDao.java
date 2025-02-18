package com.example.myart.dao;


import com.example.myart.model.Users;

import java.util.List;

public interface UserDao {
    void creatUser(Users users);

    void updatUser(Users users);

    List<Users> getAllUsers();

    Users getUserId(Long id);

    void delUser(Long id);
}