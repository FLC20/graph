package com.information.dao;

import com.information.entity.Tea2dep;
import com.information.entity.Tea2depKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tea2depMapper {
    int deleteByPrimaryKey(Tea2depKey key);

    int insert(Tea2dep record);

    int insertSelective(Tea2dep record);

    Tea2dep selectByPrimaryKey(Tea2depKey key);

    int updateByPrimaryKeySelective(Tea2dep record);

    int updateByPrimaryKey(Tea2dep record);
}