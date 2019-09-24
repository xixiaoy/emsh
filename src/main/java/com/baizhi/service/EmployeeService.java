package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> queryById(Integer id);

    void delete(Integer id);

    Employee toUpdate(Integer id);

    void update(Employee employee);

    void insert(Employee employee);
}
