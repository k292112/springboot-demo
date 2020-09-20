package com.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerDemo {

    @RequestMapping("/test")
    public String get(String name, int id, HttpSession session) {
        if ("abc".equals(name)) {
            System.out.println("大家都进来了## " + id);
        }
        return "spring MVC controller!";
    }
    @RequestMapping("/testJson")
    public Object getJson(String name){
        Map user = new HashMap();
        user.put("username","yang");
        user.put("password","yang");
        user.put("nickname","yang");
        return user;
    }
}
