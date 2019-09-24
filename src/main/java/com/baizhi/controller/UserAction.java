package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller   //创建Action对象
@RequestMapping("/user")
public class UserAction {

    @Autowired  //为service属性做注入
    private UserService userService;
    private String message;
    private String username;

    //登陆功能
    @RequestMapping("/login") //定义访问方法的路径名称
    public String login(User user, Model model, HttpSession session)throws Exception{
        User users = null;
        try{
            users = userService.queryByName(user);
            session.setAttribute("flag","Y");
            return "redirect:/dept/showAll.do";
        }catch(Exception e){
            message = e.getMessage();
            model.addAttribute("message",message);
            return "ems1.0/login";
        }

    }

    //根据用户名查询
    @RequestMapping("/queryName")
    public String queryName(String username,HttpServletResponse response){
        User users = userService.queryName(username);
        try{
            PrintWriter out = response.getWriter();
            if(users != null){
                out.print("N");
            }else{
                out.print("Y");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //注册功能
    @RequestMapping("/regist")
    public String regist(User user,HttpSession session)throws Exception{
        try {
            userService.insert(user);
            session.setAttribute("flag","Y");
            return "redirect:/dept/showAll.do";
        }catch (Exception e){
            e.printStackTrace();
            return "ems1.0/regist";
        }
    }
}
