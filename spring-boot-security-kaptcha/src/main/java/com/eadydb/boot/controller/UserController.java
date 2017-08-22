package com.eadydb.boot.controller;

import com.eadydb.boot.entity.User;
import com.eadydb.boot.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
* @Author eadydb {dengbin1201@163.com}
* @Date 17-5-5 下午1:27
* <p>
* @Description
**/
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<User>> page(User user) {
        List<User> users = userService.list(user);
        return new ResponseEntity<>(new PageInfo<>(users), HttpStatus.OK);
    }

}
