package com.information.dao;

import com.information.entity.Nodes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface NodesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Nodes record);

    int insertSelective(Nodes record);

    Nodes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Nodes record);

    int updateByPrimaryKey(Nodes record);
    ArrayList<Nodes> selectAll();

    Nodes selectNodeAll();

    Nodes selectByName();

    void insertNodes(@Param("nodeid") String nodeid,@Param("name") String name,
                     @Param("symbolSize") int symbolSize,@Param("category") int category);
}