package org.example.shop.dao.impl;

import org.example.shop.dao.UserDao;
import org.example.shop.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String email, String password) {
        User user = null;
        if ("1140@gmail.com".equals(email)) {
            if ("1234".equals(password)) {
                user = new User();
                user.setUsername("admin");
                user.setEmail("1140@gmail,com");
            }
        }
        return user;
    }
}
