package org.example.shop.web.Controller;

import org.example.shop.commons.context.SpringContext;
import org.example.shop.dao.impl.UserDaoImpl;
import org.example.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {


//    @Autowired
//    @Qualifier("userService")

    private static final UserService userService = SpringContext.getBean("userService");
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        logger.info("user \"{}\" 's password: {}", email, password);
        if (null != userService.login(email, password)) {
            try {
                req.getRequestDispatcher("login.html").forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("message", "incorrect username or password");
            try {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
