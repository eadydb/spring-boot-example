package com.eaydb.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 10:36 PM
 * <p/>
 * @DESCRIPTION
 **/
@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String username;

    private String password;

    private String email;

    private Date lastPasswordResetDate;

    private List<String> roles;

}
