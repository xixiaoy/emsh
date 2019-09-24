package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {

    User queryByName(User user);

    void insert(User user);

    User queryName(String username);
}
