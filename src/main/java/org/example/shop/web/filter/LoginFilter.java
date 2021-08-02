package org.example.shop.web.filter;

import org.example.shop.commons.context.SpringContext;
import org.example.shop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginFilter implements Filter {

    private static final UserService userService = SpringContext.getBean("userService");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println("+++++++++++++++++++++++++++++++" + Arrays.toString(req.getCookies()));
        if (null != req.getCookies()) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if ("autoLogin".equalsIgnoreCase(cookies[i].getName())) {
                        String date = cookies[i].getValue();
                        String username = date.split("-")[0];
                        String password = date.split("-")[1];

                        if (null != userService.login(username, password)) {
                            request.getRequestDispatcher("login.html").forward(req, resp);
                        } else {
                            chain.doFilter(req, resp);
                        }
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
