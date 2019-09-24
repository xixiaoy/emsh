package com.baizhi.entity;

/**
 * 员工实体类
 */
public class Employee {
    private Integer id;
    private String portrait;
    private String name;
    private String sex;
    private Integer age;
    private double salary;
    private Integer dept_id;
    private Dept dept;

    public Employee() {
    }

    public Employee(Integer id, String portrait, String name, String sex, Integer age, double salary, Integer dept_id, Dept dept) {
        this.id = id;
        this.portrait = portrait;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
        this.dept_id = dept_id;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", portrait='" + portrait + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                ", dept=" + dept +
                '}';
    }
}
