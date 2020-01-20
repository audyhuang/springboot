package com.hzy.springboot.controller;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TPermission;
import com.hzy.springboot.service.TPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Api(tags = "权限管理",description  = "关于权限操作的接口")
public class PermissionController {

    @Autowired
    TPermissionService tPermissionService;

    @ResponseBody
    @PostMapping("/getPermissionById")
    @ApiOperation(value = "查询单个权限",notes = "根据ID获取权限信息")
    public CommonRespBody<TPermission> getPermissionById(@RequestParam Integer id){
        return new CommonRespBody<>(tPermissionService.getTPermissionById(id));
    }

    @PostMapping("/addPermission")
    @ApiOperation(value = "添加权限信息",notes = "添加权限信息")
    public CommonRespBody<String> addPermission(@RequestBody TPermission tPermission){
        int flag = tPermissionService.addTPermission(tPermission);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/deleteTPermission")
    @ApiOperation(value = "删除权限信息",notes = "删除权限信息")
    public CommonRespBody<String> deleteTPermission(@RequestParam Integer id){
        int flag = tPermissionService.deleteTPermission(id);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/updateTPermission")
    @ApiOperation(value = "修改权限信息",notes = "修改权限信息")
    public CommonRespBody<String> updateTPermission(@RequestBody TPermission tPermission){
        int flag = tPermissionService.updateTPermission(tPermission);
        if(flag>0){
            return new CommonRespBody<>();
        }else {
            return new CommonRespBody<>("1001","操作失败");
        }
    }

    @PostMapping("/selectList")
    @ApiOperation(value = "查询权限信息列表",notes = "查询权限信息列表")
    public CommonRespBody<Object> selectList(@RequestBody RequestPage<TPermission> requestPage){
        ResponsePage<List<TPermission>> UserList = tPermissionService.selectList(requestPage);
        return new CommonRespBody(UserList);
    }
}
