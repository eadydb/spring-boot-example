package com.eaydb.boot.controller;

import com.eaydb.boot.entity.User;
import com.eaydb.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:44 PM
 * <p/>
 * @DESCRIPTION
 **/
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepository repository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    User addUser(User addedUser) {
        return repository.insert(addedUser);
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @GetMapping( "/{id}")
    public User getUser(@PathVariable String id) {
        return repository.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    User updateUser(@PathVariable String id, User updatedUser) {
        updatedUser.setId(id);
        return repository.save(updatedUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    User removeUser(@PathVariable String id) {
        User deletedUser = repository.findOne(id);
        repository.delete(id);
        return deletedUser;
    }

    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @GetMapping( "/")
    public User getUserByUsername(@RequestParam(value="username") String username) {
        return repository.findByUsername(username);
    }
}
