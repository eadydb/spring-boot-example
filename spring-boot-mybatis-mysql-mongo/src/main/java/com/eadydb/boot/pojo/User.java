package com.eadydb.boot.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:38
 * <p/>
 * @Description
 */
@Data
@ToString
public class User  implements Serializable{

    protected String username;

    protected String job;

    protected int age;

    protected String homeTown;
}
