package com.eadydb.boot.service;

import com.eadydb.boot.entity.SysUser;

/**
 * Created by dengbin on 16-11-25.
 */
public interface SysUserService {

    public SysUser findByUsername(String username);
}
