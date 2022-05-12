package com.information.dao;

import com.information.entity.Teachers;
import com.information.entity.TeachersWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachersMapper {
    int deleteByPrimaryKey(String teid);

    int insert(TeachersWithBLOBs record);

    int insertSelective(TeachersWithBLOBs record);

    TeachersWithBLOBs selectByPrimaryKey(String teid);

    int updateByPrimaryKeySelective(TeachersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TeachersWithBLOBs record);

    int updateByPrimaryKey(Teachers record);
}