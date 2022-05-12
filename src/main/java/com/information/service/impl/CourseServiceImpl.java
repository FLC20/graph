package com.information.service.impl;

import com.information.dao.CourseMapper;
import com.information.entity.Course;
import com.information.entity.Page;
import com.information.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public Course selectByName(String nodename){
        return courseMapper.selectByName(nodename);
    }
    public ArrayList<Course> getPage(Page<Course> pages){return courseMapper.getPage(pages);}
    public int insertCo(Course course){return courseMapper.insert(course);}
    public int updateCourse(Course course){return courseMapper.updateByPrimaryKey(course);}
    public void delCourseByCoid(String coid){courseMapper.deleteByPrimaryKey(coid);}
    public ArrayList<Course> selectLikeCourse(String coname){return courseMapper.selectLike(coname);}
}
