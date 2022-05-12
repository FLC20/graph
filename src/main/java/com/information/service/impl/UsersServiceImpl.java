package com.information.service.impl;

import com.information.dao.UsersMapper;
import com.information.entity.Page;
import com.information.entity.Users;
import com.information.service.UsersService;
import com.information.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("UsersService")
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersMapper usersMapper;
    public Users getTeacher(String teachername, String teacherpwd, int teacher){
        teacherpwd= MD5Utils.MD5(teacherpwd);
        return usersMapper.selectByTeacher(teachername,teacherpwd,teacher);
    }
    public Users getStudent(String studentname, String studentpwd, int student){
        studentpwd= MD5Utils.MD5( studentpwd);
        return usersMapper.selectByStudent(studentname, studentpwd, student);
    }
    public Users getAdmin(String adminname, String adminpwd, int admin){
        adminpwd= MD5Utils.MD5(adminpwd);
        return usersMapper.selectByAdmin(adminname,adminpwd,admin);
    }
    public Users selectTnumByTname(String teachername){
        return usersMapper.selectByTName(teachername);
    }
    public boolean updateuser(String username,String userpwd){
        userpwd=MD5Utils.MD5(userpwd);
        return usersMapper.updateuser(username,userpwd);}
    public Users getUser(String username, String userpwd){
        userpwd=MD5Utils.MD5(userpwd);
        return usersMapper.selectByUser(username,userpwd);
    }
    public  void insertUser(String stid, String stuname,
                            String password, String school, String stunum,
                            int type){
        password=MD5Utils.MD5(password);
        usersMapper.insertUser(stid,stuname,password,school,stunum,type);
    }

    public ArrayList<Users> getByPage(Page<Users> pages){
        return usersMapper.getUserByPage(pages);
    }
    public ArrayList<Users> selectAll(){
        return usersMapper.selectAll();
    }
    public Users selectByUid(String stid){return usersMapper.selectByUid(stid);}
    public void delUserByName(String username){
       usersMapper.deleteByPrimaryKey(username);
    }
}
