package com.walle.girl.realaction;


import com.walle.girl.entity.Girl;
import com.walle.girl.mapper.GirlMapper;
import com.walle.girl.realentity.UserInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginAction {

    @Autowired
    private GirlMapper girlMapper;

    @GetMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/hello");
    }
    @PostMapping("/login")
    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) {
//        String name = request.getParameter("username");
//        String password = request.getParameter("password");
        ModelAndView view = new ModelAndView();
        if (userInfo.getUsername().equals("lily") && userInfo.getPassword().equals("lily")) {
            view.setViewName("/girlList");
            List<Girl> girlList = girlMapper.getGirlList();
            view.addObject("girlList",girlList);
        } else {
            view.setViewName("/hello");
        }
        return view;
    }
}
