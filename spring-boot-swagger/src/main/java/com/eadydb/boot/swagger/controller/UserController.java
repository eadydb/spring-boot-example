package com.eadydb.boot.swagger.controller;

import com.eadydb.boot.swagger.domain.User;
import com.eadydb.boot.swagger.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dengbin on 16-11-14.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "分页查询用户信息", notes = "根据页码跟条数分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "当前页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, dataType = "Integer")
    })
    @GetMapping("/{pageNumber}-{pageSize}")
    public Page<User> pageUser(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return userRepository
                .findAll(new PageRequest(pageNumber, pageSize));
    }

    @ApiOperation(value = "查询所有用户列表")
    @GetMapping("/list")
    public List<User> listUser() {
        return (List<User>) userRepository
                .findAll();
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/create")
    public HttpStatus create(@RequestBody User user) {
        try {
            userRepository.save(user);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.NO_CONTENT;
        }
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public HttpStatus update(@PathVariable Integer id, @RequestBody User user) {
        User u = userRepository.findOne(id);
        if (u == null) {
            return HttpStatus.NOT_FOUND;
        }
        userRepository.save(user);
        return HttpStatus.OK;
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return HttpStatus.NOT_FOUND;
        }
        userRepository.delete(id);
        return HttpStatus.OK;
    }

}
