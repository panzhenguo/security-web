package com.pan.sbs.security.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author cifer_pan
 * @Date 2018/9/5 上午11:25
 * @Version 0.0.1
 * @Remark
 **/
@Data
//@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;         //
    @Column(nullable = false, unique = true, name="user_name")
    private String userName;    // 用户名
    @Column(name="user_pwd")
    private String userPwd;     // 密码
    private String salt;        // 盐
    private Integer status;         // 用户状态 -1 删除 0 禁用 1启用

    @Transient
    private List<SysRole> roleList; //角色集合

    @Transient
    private List<SysPermission> permissionList;    //资源集合


    public SysUser() {

    }

    public SysUser(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

}
