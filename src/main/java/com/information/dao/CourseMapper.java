package com.information.dao;

import com.information.entity.Course;
import com.information.entity.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(String coid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String coid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    Course selectByName(String nodename);

    ArrayList<Course> getPage(Page<Course> pages);

    ArrayList<Course> selectLike(String coname);
}