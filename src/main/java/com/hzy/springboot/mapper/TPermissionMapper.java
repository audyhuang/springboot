package com.hzy.springboot.mapper;


import com.hzy.springboot.model.mgt.TPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    List<TPermission> selectList(TPermission record);
}