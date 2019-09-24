package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  //创建service对象
@Transactional  //默认增删改事务控制
public class UserServiceImpl implements UserService{
    @Autowired  //为UserDAO属性做注入
    private UserDAO userDAO;

    //根据用户名查询登陆
    @Transactional (propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryByName(User user) {

        //定义一个变量
        User users = null;
        users = userDAO.queryByName(user.getUsername());
        if(users == null){
            throw new RuntimeException("你输入的用户不存在，请进行注册！");
        }
        if(!users.getPassword().equals(user.getPassword())){
            throw new RuntimeException("你输入的密码有误，请重新输入！");
        }
        return users;
    }

    //添加用户
    public void insert(User user) {
        userDAO.insert(user);
    }

    //根据用户名查询
    @Transactional (propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryName(String username) {
        User users = userDAO.queryByName(username);
        return users ;
    }

}
