package com.hzy.springboot.service;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRole;

import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
public interface TRoleService {

    int addTRole(TRole role);

    int updateTRole(TRole role);

    int deleteTRole(Integer id);

    TRole getTRoleById(Integer id);

    TRole getTRole(TRole role);

    ResponsePage<List<TRole>> selectList(RequestPage<TRole> requestPage);

}
