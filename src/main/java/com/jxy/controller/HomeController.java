package com.jxy.controller;

import com.jxy.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ybl
 * @Date: 2018/12/14 0014 11:07
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "jxy");
        model.addAttribute("user", user);
        return "homePage";
    }

    @RequestMapping("login")
    public String loginGet(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping("getUserInfoResponseEntity")
    public ResponseEntity<UserDetail> getUserInfoResponseEntity() {
        UserDetail u = new UserDetail();
        u.setRole("测试角色");
        u.setUserName("name");
        u.setUserPass("pass");
        return new ResponseEntity<UserDetail>(u, HttpStatus.OK);
    }

    @RequestMapping("getUserInfo")
    @ResponseBody
    public UserDetail getUserInfo(String userName) {
        UserDetail u = new UserDetail();
        u.setRole("测试角色");
        u.setUserName(userName);
        u.setUserPass("pass");
        return u;
    }

    @RequestMapping("getUserInfodx")
    @ResponseBody
    public UserDetail getUserInfodx(UserDetail userDetail) {
        userDetail.setUserName("我改了哈，服务端");
        userDetail.setRole("role");
        userDetail.setUserPass("123456");
        return userDetail;
    }
}
