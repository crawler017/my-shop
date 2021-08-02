package org.example.shop.dao.impl;

import org.example.shop.dao.UserDao;
import org.example.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

//@Component
//@Qualifier("userDao")
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User getUser(String email, String password) {
        logger.debug("revoke getUser method, arguments: {} {}", email, password);
        User user = null;
        if ("1140@gmail.com".equals(email)) {
            if ("1234".equals(password)) {
                user = new User();
                user.setUsername("admin");
                user.setEmail("1140@gmail.com");

                logger.info("require \"{}\" 's info successful", user.getUsername());
            }
            else {
                logger.warn("require \"{}\" 's info failed", email);
            }
        }
        return user;
    }
}
