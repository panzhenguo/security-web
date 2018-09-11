package com.pan.sbs.security.pojo;

import lombok.Data;

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
public class SysRole {
    private Integer id;
    private String roleName;        // 角色名称
    private String remark;          // 角色备注
    private Integer status;         // 角色状态 -1 删除 0 禁用 1启用

    private List<SysPermission> permissionList; // 资源集合

}
