package com.hzy.springboot.service;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TRolePermission;

import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
public interface TRolePermissionService {
    int addTRolePermission(TRolePermission rolePermission);

    int updateTRolePermission(TRolePermission rolePermission);

    int deleteTRolePermission(Integer id);

    TRolePermission getTRolePermissionById(Integer id);

    TRolePermission getTRolePermission(TRolePermission rolePermission);

    ResponsePage<List<TRolePermission>> selectList(RequestPage<TRolePermission> requestPage);
}
