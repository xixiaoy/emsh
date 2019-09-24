package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 部门实体类
 */
public class Dept {
    private Integer id;
    private String deptNumber; //部门编号
    private String deptName;   //部门名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatDate;    //创建日期
    private List<Employee> Employee;

    public Dept() {
    }

    public Dept(Integer id, String deptNumber, String deptName, Date creatDate, List<com.baizhi.entity.Employee> employee) {
        this.id = id;
        this.deptNumber = deptNumber;
        this.deptName = deptName;
        this.creatDate = creatDate;
        Employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public List<com.baizhi.entity.Employee> getEmployee() {
        return Employee;
    }

    public void setEmployee(List<com.baizhi.entity.Employee> employee) {
        Employee = employee;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptNumber='" + deptNumber + '\'' +
                ", deptName='" + deptName + '\'' +
                ", creatDate=" + creatDate +
                ", Employee=" + Employee +
                '}';
    }
}
