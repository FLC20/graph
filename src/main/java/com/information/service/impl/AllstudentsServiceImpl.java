package com.information.service.impl;

import com.information.dao.AllstudentsMapper;
import com.information.entity.Allstudents;
import com.information.entity.Page;
import com.information.entity.Users;
import com.information.service.AllstudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AllstudentsService")
public class AllstudentsServiceImpl implements AllstudentsService {
    @Autowired
    private AllstudentsMapper allstudentsMapper;;

    public ArrayList<Allstudents> selectStudentByNum(String studentnum){return allstudentsMapper.selectByNum(studentnum);}

    public Allstudents selectStudentNameByNum(String username){return allstudentsMapper.selectNameByNum(username);}

    public int updatestudent(Allstudents allstudents){return allstudentsMapper.updateByPrimaryKey(allstudents);}

    public Allstudents selectByID(String id){return allstudentsMapper.selectByPrimaryKey(id);}

    public int insertStudent(Allstudents student){return allstudentsMapper.insert(student);}

    public ArrayList<Allstudents> getPage(Page<Allstudents> pages){return allstudentsMapper.getPage(pages);}

    public void delstudentByUid(String stid){allstudentsMapper.deleteByPrimaryKey(stid);}

    public Allstudents selectStudentByName(String stuname){return allstudentsMapper.selectByName(stuname);}

    public Allstudents selectByUid(String stid){return allstudentsMapper.selectByPrimaryKey(stid);}
}
