package com.eadydb.boot.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by dengbin on 16-11-14.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username= #{username}")
    User findByUsername(@Param("username") String username);

    @Update("update user set password = #{password} where id = #{id}")
    void update(@Param("id") Integer id, @Param("password") String password);
}
