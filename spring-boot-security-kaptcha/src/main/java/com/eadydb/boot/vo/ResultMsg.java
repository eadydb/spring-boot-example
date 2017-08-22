package com.eadydb.boot.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by eadydb on 17-5-6.
 */
@Data
public class ResultMsg {

    private String code;

    private String error;

    private List<? extends ErrorMsg> errorMsgs;

    public ResultMsg() {
    }

    public ResultMsg(String code, String error, List<? extends ErrorMsg> errorMsgs) {
        this.code = code;
        this.error = error;
        this.errorMsgs = errorMsgs;
    }
}
