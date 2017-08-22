package com.eadydb.boot.vo;

import lombok.Getter;

/**
* @Author eadydb {dengbin1201@163.com}
* @Date 17-5-6 上午10:24
* <p>
* @Description 错误代码
**/
@Getter
public enum ErrorCode {

    ARGUMENT_INVALID_ERROR("A0001","参数校验错误"),
    BIZ_EXCEPTION_ERROR("B0001","业务操作异常");


    ErrorCode(String code, String error) {
        this.code = code;
        this.error = error;
    }

    private String code;

    private String error;

}
