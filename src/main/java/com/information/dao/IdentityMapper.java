package com.information.dao;

import com.information.entity.Identity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdentityMapper {
    int deleteByPrimaryKey(String ideid);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(String ideid);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}