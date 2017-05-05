package com.eadydb.boot.mapper;

import com.eadydb.boot.entity.User;
import com.eadydb.boot.utils.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends MybatisMapper<User> {

    User findByUsername( String username);

}