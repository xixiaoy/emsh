package com.baizhi.service;

import com.baizhi.dao.DeptDAO;
import com.baizhi.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //创建service对象
@Transactional //默认增删改事务控制
public class DeptServiceImpl implements DeptService {
    @Autowired //为属性添加对应的值
    private DeptDAO deptDAO;

    //查询部门所有信息
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> showAll() {
        List<Dept> list = deptDAO.showAll();
        return list;
    }

    //添加部门信息
    public void insert(Dept dept) {
        Dept dept1 = deptDAO.queryByName(dept.getDeptName());
        if(dept1 != null){
            throw new RuntimeException("你输入的部门已存在，请重新输入");
        }else{
            deptDAO.insert(dept);
        }
    }

    //修改部门信息
    public void update(Dept dept) {
        deptDAO.update(dept);
    }

    //根据部门id查询部门信息
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Dept queryById(Integer id) {
        Dept dept = deptDAO.queryById(id);
        return dept;
    }

    //查询部门所有部门信息
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> showAllName() {
        List<Dept> depts = deptDAO.showAll();
        return depts;
    }
}
