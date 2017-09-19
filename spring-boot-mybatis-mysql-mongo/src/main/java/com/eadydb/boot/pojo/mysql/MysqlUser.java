package com.eadydb.boot.pojo.mysql;

import com.eadydb.boot.pojo.User;
import lombok.Data;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:45
 * <p/>
 * @Description
 */
@Data
public class MysqlUser extends User {

    private Integer id;

    public MysqlUser() {
    }

    public MysqlUser(String username,String job,int age, String homeTown){
        this.username = username;
        this.job = job;
        this.age = age;
        this.homeTown = homeTown;
    }
}


