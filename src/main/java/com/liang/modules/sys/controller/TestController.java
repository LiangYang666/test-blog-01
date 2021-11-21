package com.liang.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
}
