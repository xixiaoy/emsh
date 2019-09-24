package com.baizhi.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Dept;
import com.baizhi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller //创建action对象
@RequestMapping("/dept")
public class DeptAction {
    @Autowired //为属性添加对应的值
    private DeptService deptService;
    private List<Dept> list;
    private String message;

    //查询部门所有信息功能
    @RequestMapping("/showAll")
    public String showAll(Model model)throws RuntimeException{
        list = deptService.showAll();
        model.addAttribute("list",list);
        return "ems1.0/departments";
    }

    //添加部门
    @RequestMapping("/insert")
    public String insert(Dept dept) throws Exception{
        try{
            deptService.insert(dept);
            return "redirect:/dept/showAll.do";
        }catch (Exception e){
            message = e.getMessage();
            return "ems1.0/addDepartment";
        }
    }

    //根据id查询部门信息
    @RequestMapping("/queryById")
    public String queryById(Integer id,Model model)throws Exception{
        Dept dept = deptService.queryById(id);
        model.addAttribute("dept",dept);
        System.out.println(dept);
        return "ems1.0/updateDepartment";
    }

    //修改部门信息
    @RequestMapping("/update")
    public String update(Dept dept)throws Exception{
        deptService.update(dept);
        return "redirect:/dept/showAll.do";
    }

    //查询部门信息
    @RequestMapping("/showAllName")
    public String showAllName(HttpServletResponse response)throws Exception{
        List<Dept> depts = deptService.showAllName();
        //将获取到的所有部门转换成json串
        String jsonString = JSON.toJSONString(depts);
        response.setCharacterEncoding("UTF-8");
        try{
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
