package com.information.dao;

import com.information.entity.Allteachers;
import com.information.entity.AllteachersWithBLOBs;
import com.information.entity.Page;
import com.information.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AllteachersMapper {
    int deleteByPrimaryKey(String teid);

    int insert(AllteachersWithBLOBs record);

    int insertSelective(AllteachersWithBLOBs record);

    AllteachersWithBLOBs selectByPrimaryKey(String teid);

    int updateByPrimaryKeySelective(AllteachersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AllteachersWithBLOBs record);

    int updateByPrimaryKey(Allteachers record);

    ArrayList<Allteachers> selectByNum(String teachernum);

    Allteachers selectNameByNum(String username);

    ArrayList<Allteachers> getPage(Page<Allteachers> pages);

    ArrayList<Allteachers> selectLikeByName(String tename);
}