package com.nice.demo.core.controller;

import com.nice.core.bean.UserInfo;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springbootTest
 * @description:
 * @author: lifuye
 * @create: 2018-09-07 17:58
 **/
@Api(value = "userController",tags = {"用户"})
@Controller
@RequestMapping
public class UserController {

    @ApiOperation(value="用户登录", notes="用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true ,dataType = "string")
    })
    @RequestMapping(value = "/login",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelMap login(UserInfo userInfo, HttpServletRequest request){
        return new ModelMap("msg",200);
    }
}
