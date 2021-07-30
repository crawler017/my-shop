package org.example.shop;

import org.example.shop.commons.ShopConfig;
import org.example.shop.entity.User;
import org.example.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShopConfig.class)
public class LoginTest {
    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Test
    public void test01() {
        User user = userService.login("1140@gmail.com", "1234");
        if (user !=null) {
            System.out.println(user.getEmail());
            System.out.println(user.getUsername());
        }
        else
            System.out.println("error");
    }
}
