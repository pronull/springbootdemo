package com.github.controller;


import org.apache.catalina.Session;
import org.springframework.http.HttpRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qwe on 2017/7/16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String csrf = ((CsrfToken)request.getAttribute("_csrf")).getToken();
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        //在response的header里设置_csxf
        response.setHeader("X-CSRF-TOKEN",csrf);
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}