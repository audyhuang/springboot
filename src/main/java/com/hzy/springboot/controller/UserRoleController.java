package com.hzy.springboot.controller;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUserRole;
import com.hzy.springboot.service.TUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRole")
@Api(tags = "用户角色管理",description  = "关于用户角色操作的接口")
public class UserRoleController {

    @Autowired
    TUserRoleService tUserRoleService;

    @ResponseBody
    @PostMapping("/getUserRoleById")
    @ApiOperation(value = "查询单个用户角色信息",notes = "根据ID获取用户角色信息")
    public CommonRespBody<TUserRole> getUserRoleById(@RequestParam Integer userid){
        return new CommonRespBody<>(tUserRoleService.getTUserRoleById(userid));
    }

    @PostMapping("/addUserRole")
    @ApiOperation(value = "添加用户角色信息",notes = "添加用户角色信息")
    public CommonRespBody<String> addUserRole(@RequestBody TUserRole userRole){
        int flag = tUserRoleService.addTUserRole(userRole);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/deleteUserRole")
    @ApiOperation(value = "删除用户角色信息",notes = "删除用户角色信息")
    public CommonRespBody<String> deleteUserRole(@RequestParam Integer userid){
        int flag = tUserRoleService.deleteTUserRole(userid);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/updateUserRole")
    @ApiOperation(value = "修改用户角色信息",notes = "修改用户角色信息")
    public CommonRespBody<String> updateUserRole(@RequestBody TUserRole userRole){
        int flag = tUserRoleService.updateTUserRole(userRole);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/selectList")
    @ApiOperation(value = "查询用户角色信息列表",notes = "查询用户角色信息列表")
    public CommonRespBody<Object> selectList(@RequestBody RequestPage<TUserRole> requestPage){
        ResponsePage<List<TUserRole>> UserRoleList = tUserRoleService.selectList(requestPage);
        return new CommonRespBody(UserRoleList);
    }

}
