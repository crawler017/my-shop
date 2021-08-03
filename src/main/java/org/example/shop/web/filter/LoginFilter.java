package org.example.shop.web.filter;

import org.apache.commons.lang3.StringUtils;
import org.example.shop.commons.context.SpringContext;
import org.example.shop.commons.utils.CookieUtils;
import org.example.shop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    private static final UserService userService = SpringContext.getBean("userService");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String cookie = CookieUtils.getCookieValue(req, "autologin");
        if (!StringUtils.isBlank(cookie)) {
            String username = cookie.split("-")[0];
            String password = cookie.split("-")[1];

            if (null != userService.login(username, password)) {
                request.getRequestDispatcher("main.jsp").forward(req, resp);
            } else {
                chain.doFilter(req, resp);
            }
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
