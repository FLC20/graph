package com.information.dao;

import com.information.entity.Allnodes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AllnodesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Allnodes record);

    int insertSelective(Allnodes record);

    Allnodes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Allnodes record);

    int updateByPrimaryKey(Allnodes record);

    Allnodes selectByName(String name);

    Allnodes selectByUID(String uid);

    void insertAllnodes(@Param("allnodeid") String allnodeid,@Param("uid") String uid,@Param("name") String name,
                        @Param("symbolSize") int symbolSize,@Param("category") int category);
}