package com.wzq.dao;

import com.wzq.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserListLike(String name);

    User getUesrById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
