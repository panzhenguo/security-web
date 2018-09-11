package com.pan.sbs.security.auth;

import com.pan.sbs.security.pojo.SysUser;
import com.pan.sbs.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUserAllInfo(userName);
        if (null == sysUser) {
            throw new UsernameNotFoundException(userName);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < sysUser.getPermissionList().size(); i++) {
            authorities.add(new SimpleGrantedAuthority(sysUser.getPermissionList().get(i).getName()));
        }
        return new User(sysUser.getUserName(), sysUser.getUserPwd(), authorities);
    }

}
