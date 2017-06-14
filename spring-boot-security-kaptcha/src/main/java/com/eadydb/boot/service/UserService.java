package com.eadydb.boot.service;

import com.eadydb.boot.entity.User;
import com.eadydb.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eadydb on 17-5-4.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "userCache", keyGenerator = "dbKeyGenerator")
    public List<User> list(User user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return userMapper.selectAll();
    }

    @Cacheable(value = "userCache", keyGenerator = "dbKeyGenerator", condition = "#id!=null", unless = "#result==null")
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = "userCache", keyGenerator = "dbKeyGenerator")
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @CachePut(value = "userCache", keyGenerator = "dbKeyGenerator")
    public void save(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }
}
