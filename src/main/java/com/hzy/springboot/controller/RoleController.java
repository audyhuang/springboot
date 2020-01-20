package com.hzy.springboot.controller;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRole;
import com.hzy.springboot.service.TRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(tags = "角色管理",description  = "关于角色操作的接口")
public class RoleController {

    @Autowired
    TRoleService tRoleService;

    @ResponseBody
    @PostMapping("/getTRoleById")
    @ApiOperation(value = "查询单个角色",notes = "根据ID获取角色信息")
    public CommonRespBody<TRole> getTRoleById(@RequestParam Integer id){
        return new CommonRespBody<>(tRoleService.getTRoleById(id));
    }

    @PostMapping("/addTRole")
    @ApiOperation(value = "添加角色信息",notes = "添加角色信息")
    public CommonRespBody<String> addTRole(@RequestBody TRole tRole){
        int flag = tRoleService.addTRole(tRole);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/deleteTRole")
    @ApiOperation(value = "删除角色信息",notes = "删除角色信息")
    public CommonRespBody<String> deleteTRole(@RequestParam Integer id){
        int flag = tRoleService.deleteTRole(id);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/updateTRole")
    @ApiOperation(value = "修改角色信息",notes = "修改角色信息")
    public CommonRespBody<String> updateTRole(@RequestBody TRole tRole){
        int flag = tRoleService.updateTRole(tRole);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/selectList")
    @ApiOperation(value = "查询角色信息列表",notes = "查询角色信息列表")
    public CommonRespBody<Object> selectList(@RequestBody RequestPage<TRole> requestPage){
        ResponsePage<List<TRole>> UserList = tRoleService.selectList(requestPage);
        return new CommonRespBody(UserList);
    }
}
