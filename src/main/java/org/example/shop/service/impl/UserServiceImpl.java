package org.example.shop.service.impl;

import org.example.shop.commons.context.SpringContext;
import org.example.shop.dao.UserDao;
import org.example.shop.entity.User;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@Component
//@Qualifier("UserService")
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao = SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
