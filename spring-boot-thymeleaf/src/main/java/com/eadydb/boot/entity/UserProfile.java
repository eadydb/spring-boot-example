package com.eadydb.boot.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 6/14/17 9:51 AM
 * <p/>
 * @DESCRIPTION
 **/
@Data
@Entity
@Table(name = "t_user_profile")
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "用户名:不能为空")
    private String name;

    @Range(min = 1, max = 100, message = "年龄:必须在1到100之间")
    @NotNull(message = "年龄:不能为空")
    private Integer age;

    @Size(max = 10, message = "地址:长度不能超过10 个字符")
    private String address;

}
