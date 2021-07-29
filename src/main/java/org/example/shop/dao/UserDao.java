package org.example.shop.dao;

import org.example.shop.entity.User;

public interface UserDao {

    /**
     * get User by email and password
     * @param email
     * @param password
     * @return User
     */
    public User getUser(String email, String password);
}
