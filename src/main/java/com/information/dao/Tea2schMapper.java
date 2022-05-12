package com.information.dao;

import com.information.entity.Tea2sch;
import com.information.entity.Tea2schKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tea2schMapper {
    int deleteByPrimaryKey(Tea2schKey key);

    int insert(Tea2sch record);

    int insertSelective(Tea2sch record);

    Tea2sch selectByPrimaryKey(Tea2schKey key);

    int updateByPrimaryKeySelective(Tea2sch record);

    int updateByPrimaryKey(Tea2sch record);
}