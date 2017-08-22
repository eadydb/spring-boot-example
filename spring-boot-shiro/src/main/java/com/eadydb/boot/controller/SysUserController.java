package com.eadydb.boot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengbin on 16-11-25.
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    /**
     * 用户查询.
     *
     * @return
     */
    @GetMapping("/userList")
    public String userInfo() {
        return "userInfo";
    }

    /**
     * 用户添加;
     *
     * @return
     */
    @GetMapping("/userAdd")
    @RequiresPermissions("sysuser:add")//权限管理;
    public String userInfoAdd() {
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     *
     * @return
     */
    @GetMapping("/userDel")
    @RequiresPermissions("sysuser:del")//权限管理;
    public String userDel() {
        return "userInfoDel";
    }
}
