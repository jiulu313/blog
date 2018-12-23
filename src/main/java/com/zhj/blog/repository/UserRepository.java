package com.zhj.blog.repository;


import com.zhj.blog.domain.User;

import java.util.List;

/**
 * User Repository 接口
 */
public interface UserRepository {
    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    //获取用户列表
    List<User> listUsers();

}
