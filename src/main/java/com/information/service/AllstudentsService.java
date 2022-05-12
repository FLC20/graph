package com.information.service;

import com.information.entity.Allstudents;
import com.information.entity.Page;
import com.information.entity.Users;

import java.util.ArrayList;

public interface AllstudentsService {
    ArrayList<Allstudents> selectStudentByNum(String studentnum);

    Allstudents selectStudentNameByNum(String username);

    int updatestudent(Allstudents allstudents);

    Allstudents selectByID(String id);

    int insertStudent(Allstudents student);

    ArrayList<Allstudents> getPage(Page<Allstudents> pages);

    void delstudentByUid(String stid);

    Allstudents selectStudentByName(String stuname);

    Allstudents selectByUid(String stid);
}
