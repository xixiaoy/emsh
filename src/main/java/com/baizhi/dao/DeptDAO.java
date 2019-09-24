package com.baizhi.dao;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptDAO {
     List<Dept> showAll();

    Dept queryByName(String deptName);

    void insert(Dept dept);

    void update(Dept dept);

    Dept queryById(Integer id);

}
