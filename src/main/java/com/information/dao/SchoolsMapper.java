package com.information.dao;

import com.information.entity.Page;
import com.information.entity.Schools;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface SchoolsMapper {
    int deleteByPrimaryKey(String scid);

    int insert(Schools record);

    int insertSelective(Schools record);

    Schools selectByPrimaryKey(String scid);

    int updateByPrimaryKeySelective(Schools record);

    int updateByPrimaryKey(Schools record);

    Schools selectByName(String school);

    ArrayList<Schools> getPage(Page<Schools> pages);

    ArrayList<Schools> selectLike(String scname);
}