package com.liang.modules.sys.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: test-blog-01
 * @Package: com.liang.modules.sys.controller
 * @ClassName: HomeController
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/3 0:07
 * @Version: 1.0
 */
@Controller
public class HomeController {
     /**
      * @method
      * @description 跳转至首页
      * @date: 2022/1/5 0:12
      * @author: Yang Liang
      * @param
      * @return
      */
    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

     /**
      * @method
      * @description 跳转至登陆页面，并保存跳转前的页面位置lastUrl
      * @date: 2022/1/5 0:13
      * @author: Yang Liang
      * @param
      * @return
      */
    @GetMapping("login")
    public String login(HttpServletRequest request){
        String lastUrl = request.getHeader("Referer");// 获取从哪里点进来的
        if (StringUtils.isEmpty(lastUrl)){
            return "login";
        }
        if (lastUrl.contains("findPwd") ||
            lastUrl.contains("register") ||
            lastUrl.contains("login")){
            //若为注册、找回密码等界面进的登陆连接则删除lastUrl属性，这样就可以在登陆完成时不会又重新跳转回注册、找回密码等链接
            request.getSession().removeAttribute("lastUrl");
        } else {
            //保存跳转页面之前的url
            request.getSession().setAttribute("lastUrl", lastUrl);
        }
        return "login";
    }

     /**
      * @method
      * @description 跳转到index.html或lasturl.html，保存存储的链接到response头
      * @date: 2022/1/5 9:22
      * @author: Yang Liang
      * @param
      * @return
      */
    @GetMapping("lasturl")
    public String lastUrl(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入了lastUrl");
//        response.setHeader("Access-Control-Allow-Origin", "*");
        String lastUrl = (String) request.getSession().getAttribute("lastUrl");
        if (StringUtils.isEmpty(lastUrl)){
            System.out.println("index ==> 1");
            System.out.println(lastUrl);
            return "index";
        } else {
            response.setHeader("lastUrl", lastUrl);
            System.out.println("index ==> 2");
            System.out.println(lastUrl);
            return "lasturl";
        }
    }
}