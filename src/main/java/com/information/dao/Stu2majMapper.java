package com.information.dao;

import com.information.entity.Stu2maj;
import com.information.entity.Stu2majKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Stu2majMapper {
    int deleteByPrimaryKey(Stu2majKey key);

    int insert(Stu2maj record);

    int insertSelective(Stu2maj record);

    Stu2maj selectByPrimaryKey(Stu2majKey key);

    int updateByPrimaryKeySelective(Stu2maj record);

    int updateByPrimaryKey(Stu2maj record);
}