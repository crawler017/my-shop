package org.example.shop.service;

import org.example.shop.entity.User;

public interface UserService {

    /**
     * login
     * @param email
     * @param password
     * @return User
     */
    public User login(String email, String password);
}
