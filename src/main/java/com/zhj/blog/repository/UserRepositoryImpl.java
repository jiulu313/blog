package com.zhj.blog.repository;


import com.zhj.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User Repository 接口
 */

@Repository
public class UserRepositoryImpl implements UserRepository {
    //用于生成用户唯一的ID
    private static AtomicLong counter = new AtomicLong();
    private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();


    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) {   //新建
            id = counter.incrementAndGet();
            user.setId(id);
        }

        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(this.userMap.values());
    }
}
