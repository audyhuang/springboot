package com.hzy.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzy.springboot.mapper.TUserRoleMapper;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUserRole;
import com.hzy.springboot.service.TUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
@Service
public class TUserRoleServiceImpl implements TUserRoleService {

    @Resource
    TUserRoleMapper tUserRoleMapper;

    @Override
    public int addTUserRole(TUserRole userRole) {
        return tUserRoleMapper.insert(userRole);
    }

    @Override
    public int updateTUserRole(TUserRole userRole) {
        return tUserRoleMapper.updateByPrimaryKey(userRole);
    }

    @Override
    public int deleteTUserRole(Integer id) {
        return tUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TUserRole getTUserRoleById(Integer id) {
        return tUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public TUserRole getTUserRole(TUserRole userRole) {
        return null;
    }

    @Override
    public ResponsePage<List<TUserRole>> selectList(RequestPage<TUserRole> requestPage) {
        PageHelper.startPage(requestPage.getPageIndex(),requestPage.getPageSize());
        List<TUserRole> tUserRoleList = tUserRoleMapper.selectList(requestPage.getData());
        PageInfo<TUserRole> pageInfo = new PageInfo<>(tUserRoleList);
        ResponsePage<List<TUserRole>> responsePage = new ResponsePage<>();
        responsePage.setPageIndex(requestPage.getPageIndex());
        responsePage.setPageSize(requestPage.getPageSize());
        responsePage.setData(tUserRoleList);
        responsePage.setTotalSize(pageInfo.getTotal());
        return responsePage;
    }


}
