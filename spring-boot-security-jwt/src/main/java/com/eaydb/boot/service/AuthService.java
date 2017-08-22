package com.eaydb.boot.service;

import com.eaydb.boot.entity.User;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:26 PM
 * <p/>
 * @DESCRIPTION
 **/
public interface AuthService {

    User register(User user);

    String login(String username, String password);

    String refresh(String oldToken);

}
