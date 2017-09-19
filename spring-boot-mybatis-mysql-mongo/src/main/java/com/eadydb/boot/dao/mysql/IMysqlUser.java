package com.eadydb.boot.dao.mysql;

import com.eadydb.boot.pojo.mysql.MysqlUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:48
 * <p/>
 * @Description
 */
public interface IMysqlUser {

    @Select("SELECT * FROM user WHERE id = #{userId}")
    public MysqlUser getUser(int userId);

    @Insert("insert into user (username,job,age,hometown) values (#{username},#{job},#{age},#{homeTown})")
    public int addUser(MysqlUser user);
}
