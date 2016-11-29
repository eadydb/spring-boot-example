package com.eadydb.boot.service.impl;

import com.eadydb.boot.entity.SysUser;
import com.eadydb.boot.repository.SysUserRepository;
import com.eadydb.boot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengbin on 16-11-25.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
