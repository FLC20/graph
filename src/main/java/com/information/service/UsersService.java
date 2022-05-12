package com.information.service;

import com.information.entity.Page;
import com.information.entity.Users;

import java.util.ArrayList;

public interface UsersService {
    Users getTeacher(String teachername, String teacherpwd, int teacher);

    Users getStudent(String studentname, String studentpwd, int student);

    Users getAdmin(String adminname, String adminpwd, int admin);

    Users selectTnumByTname(String teachername);

    boolean updateuser(String username,String userpwd);

    Users getUser(String username, String userpwd);

    ArrayList<Users> getByPage(Page<Users> pages);

    ArrayList<Users> selectAll();

    Users selectByUid(String stid);

    void insertUser(String stid, String stuname, String password, String school, String stunum, int type);

    void delUserByName(String username);
}
