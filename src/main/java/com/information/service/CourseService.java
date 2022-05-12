package com.information.service;

import com.information.entity.Course;
import com.information.entity.Page;

import java.util.ArrayList;

public interface CourseService {
    Course selectByName(String nodename);

    ArrayList<Course> getPage(Page<Course> pages);

    int insertCo(Course course);

    int updateCourse(Course course);

    void delCourseByCoid(String coid);

    ArrayList<Course> selectLikeCourse(String coname);
}
