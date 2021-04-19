package com.org.fourfly.controller;

import com.org.fourfly.exception.InvalidArgumentException;
import com.org.fourfly.service.UserDetailsInfoService;
import com.org.fourfly.util.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author Jian
 * @Date 2021/2/12 0:20:01
 * @Description 登录控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "fourfly")
@Api(value = "Login-Controller", tags = "后台-登录控制器")
public class LoginController {

    @Resource
    private UserDetailsInfoService userDetailsInfoService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ApiOperation(value = "登录接口")
    public String login(
            @ApiParam(value = "用户名") @RequestParam(value = "username", required = false) String username,
            @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password,
            HttpSession httpSession
    ){
        if (null == username || "".equals(username)){
            throw new InvalidArgumentException("用户名不能为空！");
        }
        if (null == password || "".equals(password)){
            throw new InvalidArgumentException("密码不能为空！");
        }
        UserDetails userDetails = userDetailsInfoService.loadUserByUsername(username);
        if (!userDetails.getPassword().equals(MD5.MD5(password))) {
            throw new InvalidArgumentException("账户或密码错误！");
        }
        return "登录成功";
    }
}
