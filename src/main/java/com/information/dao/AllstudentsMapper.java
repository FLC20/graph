package com.information.dao;

import com.information.entity.Allstudents;
import com.information.entity.Page;
import com.information.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AllstudentsMapper {
    int deleteByPrimaryKey(String stid);

    int insert(Allstudents record);

    int insertSelective(Allstudents record);

    Allstudents selectByPrimaryKey(String stid);

    int updateByPrimaryKeySelective(Allstudents record);

    int updateByPrimaryKey(Allstudents record);

    ArrayList<Allstudents> selectByNum(String studentnum);

    Allstudents selectNameByNum(String username);

    ArrayList<Allstudents> getPage(Page<Allstudents> pages);

    Allstudents selectByName(String stuname);
}