package com.baizhi.service;

import com.baizhi.dao.EmployeeDAO;
import com.baizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    //根据部门id查询员工信息
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Employee> queryById(Integer id) {
        List<Employee> list= employeeDAO.queryById(id);
        return list;
    }

    //删除用户信息
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }

    //根据id查询
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Employee toUpdate(Integer id) {
        Employee employee = employeeDAO.toUpdate(id);
        return employee;
    }

    //修改用户信息
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    //添加员工信息
    public void insert(Employee employee) {
        employeeDAO.insert(employee);
    }
}
