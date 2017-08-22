package com.eaydb.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:51 PM
 * <p/>
 * @DESCRIPTION
 **/
@Data
public class Todo {

    @Id
    private String id;

    private String desc;
    private boolean completed;
    private User user;
}
