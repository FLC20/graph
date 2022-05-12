package com.information.dao;

import com.information.entity.Stu2cou;
import com.information.entity.Stu2couKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Stu2couMapper {
    int deleteByPrimaryKey(Stu2couKey key);

    int insert(Stu2cou record);

    int insertSelective(Stu2cou record);

    Stu2cou selectByPrimaryKey(Stu2couKey key);

    int updateByPrimaryKeySelective(Stu2cou record);

    int updateByPrimaryKey(Stu2cou record);
}