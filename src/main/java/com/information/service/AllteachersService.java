package com.information.service;

import com.information.entity.Allteachers;
import com.information.entity.AllteachersWithBLOBs;
import com.information.entity.Page;
import com.information.entity.Users;

import java.util.ArrayList;

public interface AllteachersService {
    ArrayList<Allteachers> selectTeacherByNum(String teachernum);

    Allteachers selectTeacherNameByNum(String username);

    int updateteacher(Allteachers teacher);

    void updateteacher2(AllteachersWithBLOBs teacherblobs);

    Allteachers selectByID(String nodeid);

    ArrayList<Allteachers> getPage(Page<Allteachers> pages);

    int insertTeacher(AllteachersWithBLOBs teacherblobs);

    void delteacherByUid(String teid);

    ArrayList<Allteachers> selectLikeByName(String tename);
}
