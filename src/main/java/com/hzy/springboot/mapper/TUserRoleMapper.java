package com.hzy.springboot.mapper;


import com.hzy.springboot.model.mgt.TUser;
import com.hzy.springboot.model.mgt.TUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);

    List<TUserRole> selectList(TUserRole record);

}