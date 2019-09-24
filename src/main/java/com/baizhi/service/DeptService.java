package com.baizhi.service;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> showAll();

    void insert(Dept dept);

    void update(Dept dept);

    Dept queryById(Integer id);


    List<Dept> showAllName();
}
