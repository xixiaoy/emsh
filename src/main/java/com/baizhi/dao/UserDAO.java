package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {
    User queryByName(String username);

    void insert(User user);
}
