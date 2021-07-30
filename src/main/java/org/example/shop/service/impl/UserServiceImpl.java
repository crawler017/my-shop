package org.example.shop.service.impl;

import org.example.shop.commons.context.SpringContext;
import org.example.shop.dao.UserDao;
import org.example.shop.entity.User;
import org.example.shop.service.UserService;

//@Component
//@Qualifier("UserService")
public class UserServiceImpl implements UserService {




    @Override
    public User login(String email, String password) {
        SpringContext springContext = new SpringContext();
        UserDao userDao = (UserDao) springContext.getBean("userDao");
        return userDao.getUser(email, password);
    }
}
