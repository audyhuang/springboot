package com.hzy.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzy.springboot.mapper.TRoleMapper;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRole;
import com.hzy.springboot.service.TRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
@Service
public class TRoleServiceImpl implements TRoleService {

    @Resource
    TRoleMapper tRoleMapper;

    @Override
    public int addTRole(TRole role) {
        return tRoleMapper.insert(role);
    }

    @Override
    public int updateTRole(TRole role) {
        return tRoleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteTRole(Integer id) {
        return tRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TRole getTRoleById(Integer id) {
        return tRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public TRole getTRole(TRole role) {
        return null;
    }

    @Override
    public ResponsePage<List<TRole>> selectList(RequestPage<TRole> requestPage) {
        PageHelper.startPage(requestPage.getPageIndex(),requestPage.getPageSize());
        List<TRole> tRoleList = tRoleMapper.selectList(requestPage.getData());
        PageInfo<TRole> pageInfo = new PageInfo<>(tRoleList);
        ResponsePage<List<TRole>> responsePage = new ResponsePage<>();
        responsePage.setPageIndex(requestPage.getPageIndex());
        responsePage.setPageSize(requestPage.getPageSize());
        responsePage.setData(tRoleList);
        responsePage.setTotalSize(pageInfo.getTotal());
        return responsePage;
    }

}
