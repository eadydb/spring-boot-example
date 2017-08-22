package com.eaydb.boot.jwt;

import lombok.Data;

import java.io.Serializable;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 10:47 PM
 * <p/>
 * @DESCRIPTION
 **/
@Data
public class JwtAuthenticationRequest implements Serializable {

    private String username;

    private String password;

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
