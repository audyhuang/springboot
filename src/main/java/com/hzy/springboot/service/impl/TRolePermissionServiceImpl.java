package com.hzy.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzy.springboot.mapper.TRolePermissionMapper;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRolePermission;
import com.hzy.springboot.service.TRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
@Service
public class TRolePermissionServiceImpl implements TRolePermissionService {

    @Resource
    TRolePermissionMapper tRolePermissionMapper;

    @Override
    public int addTRolePermission(TRolePermission rolePermission) {
        return tRolePermissionMapper.insert(rolePermission);
    }

    @Override
    public int updateTRolePermission(TRolePermission rolePermission) {
        return tRolePermissionMapper.updateByPrimaryKey(rolePermission);
    }

    @Override
    public int deleteTRolePermission(Integer id) {
        return tRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TRolePermission getTRolePermissionById(Integer id) {
        return tRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public TRolePermission getTRolePermission(TRolePermission rolePermission) {
        return null;
    }

    @Override
    public ResponsePage<List<TRolePermission>> selectList(RequestPage<TRolePermission> requestPage) {
        PageHelper.startPage(requestPage.getPageIndex(),requestPage.getPageSize());
        List<TRolePermission> tRolePermissionList = tRolePermissionMapper.selectList(requestPage.getData());
        PageInfo<TRolePermission> pageInfo = new PageInfo<>(tRolePermissionList);
        ResponsePage<List<TRolePermission>> responsePage = new ResponsePage<>();
        responsePage.setPageIndex(requestPage.getPageIndex());
        responsePage.setPageSize(requestPage.getPageSize());
        responsePage.setData(tRolePermissionList);
        responsePage.setTotalSize(pageInfo.getTotal());
        return responsePage;
    }

}
