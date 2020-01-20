package com.hzy.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzy.springboot.mapper.TPermissionMapper;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TPermission;
import com.hzy.springboot.model.mgt.TUser;
import com.hzy.springboot.service.TPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
@Service
public class TPermissionServiceImpl implements TPermissionService {

    @Resource
    TPermissionMapper tPermissionMapper;

    @Override
    public int addTPermission(TPermission permission) {
        return tPermissionMapper.insert(permission);
    }

    @Override
    public int updateTPermission(TPermission permission) {
        return tPermissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public int deleteTPermission(Integer id) {
        return tPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TPermission getTPermissionById(Integer id) {
        return tPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public TPermission getTPermission(TPermission permission) {
        return null;
    }

    @Override
    public ResponsePage<List<TPermission>> selectList(RequestPage<TPermission> requestPage) {
        PageHelper.startPage(requestPage.getPageIndex(),requestPage.getPageSize());
        List<TPermission> tPermissionList = tPermissionMapper.selectList(requestPage.getData());
        PageInfo<TPermission> pageInfo = new PageInfo<>(tPermissionList);
        ResponsePage<List<TPermission>> responsePage = new ResponsePage<>();
        responsePage.setPageIndex(requestPage.getPageIndex());
        responsePage.setPageSize(requestPage.getPageSize());
        responsePage.setData(tPermissionList);
        responsePage.setTotalSize(pageInfo.getTotal());
        return responsePage;
    }

}
