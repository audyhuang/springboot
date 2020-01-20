package com.hzy.springboot.service;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TUserRole;

import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
public interface TUserRoleService {

    int addTUserRole(TUserRole userRole);

    int updateTUserRole(TUserRole userRole);

    int deleteTUserRole(Integer id);

    TUserRole getTUserRoleById(Integer id);

    TUserRole getTUserRole(TUserRole userRole);

    ResponsePage<List<TUserRole>> selectList(RequestPage<TUserRole> requestPage);
}
