package com.example.myart.dao;

import com.example.myart.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaolmp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void creatUser(Users users) {
        entityManager.persist(users);
    }

    @Override
    public void updatUser(Users users) {
        entityManager.merge(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u", Users.class)
                .getResultList();
    }

    @Override
    public Users getUserId(Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void delUser(Long id) {
        entityManager.remove(getUserId(id));
    }
}