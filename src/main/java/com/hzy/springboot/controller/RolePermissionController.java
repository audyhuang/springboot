package com.hzy.springboot.controller;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRolePermission;
import com.hzy.springboot.service.TRolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolePermission")
@Api(tags = "角色权限管理",description  = "关于角色权限操作的接口")
public class RolePermissionController {

    @Autowired
    TRolePermissionService tRolePermissionService;

    @ResponseBody
    @PostMapping("/getTRolePermissionById")
    @ApiOperation(value = "查询单个角色权限",notes = "根据ID获取角色权限信息")
    public CommonRespBody<TRolePermission> getTRolePermissionById(@RequestParam Integer id){
        return new CommonRespBody<>(tRolePermissionService.getTRolePermissionById(id));
    }

    @PostMapping("/addTRolePermission")
    @ApiOperation(value = "添加角色信息权限",notes = "添加角色权限信息")
    public CommonRespBody<String> addTRolePermission(@RequestBody TRolePermission tRolePermission){
        int flag = tRolePermissionService.addTRolePermission(tRolePermission);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/deleteTRolePermission")
    @ApiOperation(value = "删除角色权限信息",notes = "删除角色权限信息")
    public CommonRespBody<String> deleteTRolePermission(@RequestParam Integer id){
        int flag = tRolePermissionService.deleteTRolePermission(id);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/updateTRolePermission")
    @ApiOperation(value = "修改角色权限信息",notes = "修改角色权限信息")
    public CommonRespBody<String> updateTRolePermission(@RequestBody TRolePermission tRolePermission){
        int flag = tRolePermissionService.updateTRolePermission(tRolePermission);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/selectList")
    @ApiOperation(value = "查询角色权限信息列表",notes = "查询角色权限信息列表")
    public CommonRespBody<Object> selectList(@RequestBody RequestPage<TRolePermission> requestPage){
        ResponsePage<List<TRolePermission>> UserList = tRolePermissionService.selectList(requestPage);
        return new CommonRespBody(UserList);
    }
}
