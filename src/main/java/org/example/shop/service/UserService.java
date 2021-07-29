package org.example.shop.service;

import org.example.shop.entity.User;

public interface UserService {

    /**
     * login
     * @param username
     * @param password
     * @return User
     */
    public User login(String username, String password);
}
