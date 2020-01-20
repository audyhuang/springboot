package com.hzy.springboot.service;

import com.hzy.springboot.model.common.req.RequestPage;
import com.hzy.springboot.model.common.resp.ResponsePage;
import com.hzy.springboot.model.mgt.TPermission;

import java.util.List;

/**
 * @作者 huangzhiyong
 * @创建时间 2020-1-19
 * @描述
 */
public interface TPermissionService {

    int addTPermission(TPermission permission);

    int updateTPermission(TPermission permission);

    int deleteTPermission(Integer id);

    TPermission getTPermissionById(Integer id);

    TPermission getTPermission(TPermission permission);

    ResponsePage<List<TPermission>> selectList(RequestPage<TPermission> requestPage);

}
