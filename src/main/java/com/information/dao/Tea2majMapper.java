package com.information.dao;

import com.information.entity.Tea2maj;
import com.information.entity.Tea2majKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tea2majMapper {
    int deleteByPrimaryKey(Tea2majKey key);

    int insert(Tea2maj record);

    int insertSelective(Tea2maj record);

    Tea2maj selectByPrimaryKey(Tea2majKey key);

    int updateByPrimaryKeySelective(Tea2maj record);

    int updateByPrimaryKey(Tea2maj record);
}