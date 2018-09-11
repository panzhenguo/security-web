package com.pan.sbs.security.web;

import com.pan.sbs.security.core.R;
import com.pan.sbs.security.pojo.SysUser;
import com.pan.sbs.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeIndex {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public R index() {
        SysUser sysUserByName = userService.getSysUserByName("zs");
        return R.getSuccess(sysUserByName);
    }

    @RequestMapping("add")
    public R add() {
        SysUser sysUser = userService.addSysUser(null);
        return R.getSuccess(sysUser);
    }

    @RequestMapping("list")
    public R list(){
        return R.getSuccess(userService.getAllUser());
    }

}
