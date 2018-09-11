package com.pan.sbs.security.service.impl;

import com.pan.sbs.security.mapper.SysUserMapper;
import com.pan.sbs.security.pojo.SysPermission;
import com.pan.sbs.security.pojo.SysUser;
import com.pan.sbs.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser addSysUser(SysUser sysUser) {
        sysUser = new SysUser();
        String uuid= UUID.randomUUID().toString();
        sysUser.setSalt(uuid);
        sysUser.setUserName(uuid.substring(1,5));
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        sysUser.setUserPwd(encode.encode(sysUser.getUserName()));
        sysUser.setStatus(1);
        sysUserMapper.insert(sysUser);
        return sysUser;
    }

    @Override
    public SysUser getSysUserByName(String userName) {
        return new SysUser();
    }

    @Override
    public SysUser getUserAllInfo(String userName) {
        SysUser su = getSysUserByName(userName);

        su.setUserName("zs");
        su.setUserPwd("$2a$10$ApICaxsE.i1a8CrRXy/15OpZoIshw2vjL7O8kKNS4occEeOr.w6Mu");
        su.setSalt("dasd3213fdsvzxcasdqwevdhyruy");


        List<SysPermission> spl = new ArrayList<SysPermission>();
        SysPermission sp = null;
        for (int i = 0; i < 10; i++) {
            sp = new SysPermission();
            sp.setType(2);
            sp.setName("spl:add");
            spl.add(sp);
        }
        su.setPermissionList(spl);
        return su;
    }

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.selectAll();
    }

}
