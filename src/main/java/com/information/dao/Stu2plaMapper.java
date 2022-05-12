package com.information.dao;

import com.information.entity.Stu2pla;
import com.information.entity.Stu2plaKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Stu2plaMapper {
    int deleteByPrimaryKey(Stu2plaKey key);

    int insert(Stu2pla record);

    int insertSelective(Stu2pla record);

    Stu2pla selectByPrimaryKey(Stu2plaKey key);

    int updateByPrimaryKeySelective(Stu2pla record);

    int updateByPrimaryKey(Stu2pla record);
}