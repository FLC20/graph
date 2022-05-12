package com.information.dao;

import com.information.entity.Stu2sch;
import com.information.entity.Stu2schKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Stu2schMapper {
    int deleteByPrimaryKey(Stu2schKey key);

    int insert(Stu2sch record);

    int insertSelective(Stu2sch record);

    Stu2sch selectByPrimaryKey(Stu2schKey key);

    int updateByPrimaryKeySelective(Stu2sch record);

    int updateByPrimaryKey(Stu2sch record);
}