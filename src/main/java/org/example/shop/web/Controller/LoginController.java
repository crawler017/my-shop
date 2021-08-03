package org.example.shop.web.Controller;

import org.example.shop.entity.User;
import org.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * jump to login page
     *
     * @return login page
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * login function
     *
     * @param email
     * @param password
     * @return response page
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email,
                        @RequestParam(required = true) String password,
                        @RequestParam(required = false) String isRemember,
                        HttpServletRequest req,
                        HttpServletResponse resp) {
        User user;
        if (null != (user = userService.login(email, password))) {
            req.getSession().setAttribute("user", user);
            return "redirect:/main";
        } else {
            return login();
        }
    }

//    @Autowired
//    @Qualifier("userService")

//    private static final long serialVersionUID = 1L;
//    private static final UserService userService = SpringContext.getBean("userService");
//    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String isRemember = req.getParameter("isRemember");
//
//
//        //logger.info("user \"{}\" 's password: {}", email, password);
//        if (null != userService.login(email, password)) {
//            try {
//                if (null != isRemember) {
//                    // set cookie
//                    CookieUtils.setCookie(req, resp, "autologin", email+"-"+password, 60*100);
//                }
//                req.getRequestDispatcher("main.jsp").forward(req, resp);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            req.setAttribute("message", "incorrect username or password");
//            try {
//                req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
