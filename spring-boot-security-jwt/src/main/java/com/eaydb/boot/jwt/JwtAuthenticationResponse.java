package com.eaydb.boot.jwt;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 10:47 PM
 * <p/>
 * @DESCRIPTION
 **/
@Getter
public class JwtAuthenticationResponse implements Serializable {

    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
