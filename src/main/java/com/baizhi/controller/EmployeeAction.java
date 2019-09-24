package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeAction {
    @Autowired
    private EmployeeService employeeService;
    private List<Employee> list;

    //根据部门id查询员工信息
    @RequestMapping("/queryById")
    public String queryById(Integer id,Model model)throws Exception{
        list = employeeService.queryById(id);
        model.addAttribute("list",list);
        return "ems1.0/emplist";
    }

    //删除员工信息
    @RequestMapping("/delete")
    public String delete(Integer id,Integer dept_id){
        employeeService.delete(id);
        return  "redirect:/emp/queryById.do?id="+dept_id;
    }

    //根据id查询修改
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Model model)throws Exception{
        Employee employee = employeeService.toUpdate(id);
        model.addAttribute("employee",employee);
        return "ems1.0/updateEmp";
    }

    //修改用户信息
    @RequestMapping("/update")
    public String update(Employee employee, HttpSession session,MultipartFile upload)throws Exception{
        if(upload.getSize() != 0 ){
            //获取upload目标文件夹的路径
            ServletContext servletContext = session.getServletContext();
            //获取upload对应的路径
            String realPath = servletContext.getRealPath("/upload");
            try{
                //把上传的文件输出到/upload文件夹中 文件名字
                //在upload文件中创建了与上传文件同名的文件 空文件
                File file = new File(realPath+"/"+upload.getOriginalFilename());
                //把上传的文件内容转换到空文件
                upload.transferTo(file);
            }catch(Exception e){
                e.printStackTrace();
            }
            //赋值获取到添加的图片
            employee.setPortrait(upload.getOriginalFilename());
        }
        employeeService.update(employee);
        return "redirect:/emp/queryById.do?id="+employee.getDept_id();

    }

    //添加员工信息
    @RequestMapping("/insert")
    public String insert(Employee employee, HttpSession session,MultipartFile upload)throws Exception{
        System.out.println(employee);
        //获取upload目标文件夹的路径
        ServletContext servletContext = session.getServletContext();
        //获取upload对应的路径
        String realPath = servletContext.getRealPath("/upload");
        try{
            //把上传的文件输出到/upload文件夹中 文件名字
            //在upload文件中创建了与上传文件同名的文件 空文件
            File file = new File(realPath+"/"+upload.getOriginalFilename());
            //把上传的文件内容转换到空文件
            upload.transferTo(file);
            employee.setPortrait(upload.getOriginalFilename());
            employeeService.insert(employee);

            return "redirect:/emp/queryById.do?id="+employee.getDept_id();
        }catch(Exception e){
            e.printStackTrace();
            return "ems1.0/addEmp";
        }

    }
}
