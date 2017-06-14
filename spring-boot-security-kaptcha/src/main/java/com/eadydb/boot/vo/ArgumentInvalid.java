package com.eadydb.boot.vo;

import lombok.Data;

/**
* @Author eadydb {dengbin1201@163.com}
* @Date 17-5-6 上午10:10
* <p>
* @Description 参数校验错误信息
**/
@Data
public class ArgumentInvalid extends ErrorMsg {

    private String field;

    private Object rejectedValue;

    private String message;

}
