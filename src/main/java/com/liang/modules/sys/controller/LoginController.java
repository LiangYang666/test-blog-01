package com.liang.modules.sys.controller;

import com.liang.common.utils.JsonResult;
import com.liang.modules.sys.entity.VO.UserVOEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @GetMapping("loginUser")
    public JsonResult loginUser(@RequestParam("phone") String phone,
                                @RequestParam("password") String password,
                                HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserVOEntity user = (UserVOEntity) subject.getPrincipal();
            user.setPassword("");
            session.setAttribute("user", user);
            return new JsonResult(200, "ok", null);
        } catch (AuthenticationException e){
            return new JsonResult(500, "用户名或密码错误", null);
        }
    }
}
