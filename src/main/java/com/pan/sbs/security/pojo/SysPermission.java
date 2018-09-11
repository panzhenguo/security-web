package com.pan.sbs.security.pojo;

import lombok.Data;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author cifer_pan
 * @Date 2018/9/5 上午11:25
 * @Version 0.0.1
 * @Remark
 **/
@Data
public class SysPermission {
    private Integer id;
    private String name;           // 资源名称
    private String url;             // 资源地址
    private Integer type;           // 资源类型 1 链接 2 按钮
    private String pid;             // 父id 集合
    private String mark;            // 资源备注


    private Integer status;         // 资源状态 -1 删除 0 禁用 1启用
}
