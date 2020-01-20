package com.hzy.springboot.controller;


import com.hzy.springboot.enums.UserError;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUser;
import com.hzy.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "用户管理",description  = "关于用户操作的接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/index")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public String index(@RequestBody TUser user){
        log.info(user.toString());
        return "success";
    }

//    @ResponseBody
    @GetMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户登录")
    public CommonRespBody<TUser> login(@ModelAttribute TUser user){
        if(Objects.isNull(user)|| StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return new CommonRespBody<>(UserError.REQUEST_NOT_NULL);
        }
        TUser tUser = userService.getUserByUsername(user.getUsername());
        if(Objects.isNull(tUser)){
            return new CommonRespBody<>(UserError.USER_NOT_EXIST);
        }
        if(!user.getPassword().equals(tUser.getPassword())){
            return new CommonRespBody<>(UserError.PASSWORD_ERROR);
        }
        return new CommonRespBody<>();
    }

    @ResponseBody
    @PostMapping("/getUserById")
    @ApiOperation(value = "查询单个用户信息",notes = "根据ID获取用户信息")
    public CommonRespBody<TUser> getUserById(@RequestParam Integer userid){
        return new CommonRespBody<>(userService.getUserById(userid));
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户信息",notes = "添加用户信息")
    public CommonRespBody<String> addUser(@RequestBody TUser user){
        int flag = userService.addUser(user);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "删除用户信息",notes = "删除用户信息")
    public CommonRespBody<String> deleteUser(@RequestParam Integer userid){
        int flag = userService.deleteUser(userid);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息")
    public CommonRespBody<String> updateUser(@RequestBody TUser user){
        int flag = userService.updateUser(user);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/selectList")
    @ApiOperation(value = "查询用户信息列表",notes = "查询用户信息列表")
    public CommonRespBody<Object> selectList(@RequestBody RequestPage<TUser> requestPage){
        ResponsePage<List<TUser>> UserList = userService.getResultPage(requestPage);
        return new CommonRespBody(UserList);
    }
}
