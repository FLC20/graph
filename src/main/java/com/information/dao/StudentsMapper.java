package com.information.dao;

import com.information.entity.Students;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentsMapper {
    int deleteByPrimaryKey(String stid);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String stid);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);
}