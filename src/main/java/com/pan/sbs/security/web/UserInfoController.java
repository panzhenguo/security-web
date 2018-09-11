package com.pan.sbs.security.web;

import com.pan.sbs.security.core.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/6 下午3:44
 * @Version 0.0.1
 * @Remark
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @PreAuthorize("hasAuthority('spl:add')")
    @GetMapping("/getinstance")
    public R getInstance() {

        return R.getSuccess(new String());
    }
}
