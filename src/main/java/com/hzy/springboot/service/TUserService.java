package com.hzy.springboot.service;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUser;

import java.util.List;

public interface TUserService {

    int addUser(TUser user);

    int deleteUser(Integer userid);

    int updateUser(TUser user);

    TUser getUserById(Integer userId);

    ResponsePage<List<TUser>> getResultPage(RequestPage<TUser> requestPage);

    TUser getUserByUsername(String username);
}
