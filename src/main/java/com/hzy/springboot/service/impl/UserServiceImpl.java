package com.hzy.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzy.springboot.mapper.TUserMapper;
import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUser;
import com.hzy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public TUserMapper userMapper;

    @Override
    public int addUser(TUser user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int updateUser(TUser user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public TUser getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public ResponsePage<List<TUser>> getResultPage(RequestPage<TUser> requestPage) {
        PageHelper.startPage(requestPage.getPageIndex(),requestPage.getPageSize());
        List<TUser> userList = userMapper.selectList(requestPage.getData());
        PageInfo<TUser> pageInfo = new PageInfo<>(userList);
        ResponsePage<List<TUser>> responsePage = new ResponsePage<>();
        responsePage.setPageIndex(requestPage.getPageIndex());
        responsePage.setPageSize(requestPage.getPageSize());
        responsePage.setData(userList);
        responsePage.setTotalSize(pageInfo.getTotal());
        return responsePage;
    }

    @Override
    public TUser getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
