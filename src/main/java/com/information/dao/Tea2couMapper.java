package com.information.dao;

import com.information.entity.Tea2cou;
import com.information.entity.Tea2couKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tea2couMapper {
    int deleteByPrimaryKey(Tea2couKey key);

    int insert(Tea2cou record);

    int insertSelective(Tea2cou record);

    Tea2cou selectByPrimaryKey(Tea2couKey key);

    int updateByPrimaryKeySelective(Tea2cou record);

    int updateByPrimaryKey(Tea2cou record);
}