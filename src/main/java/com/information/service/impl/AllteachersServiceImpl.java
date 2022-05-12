package com.information.service.impl;

import com.information.dao.AllteachersMapper;
import com.information.entity.Allteachers;
import com.information.entity.AllteachersWithBLOBs;
import com.information.entity.Page;
import com.information.entity.Users;
import com.information.service.AllteachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AllteachersService")
public class AllteachersServiceImpl implements AllteachersService {
    @Autowired
    private AllteachersMapper allteachersMapper;
    public ArrayList<Allteachers> selectTeacherByNum(String teachernum){
        return allteachersMapper.selectByNum(teachernum);
    }
    public Allteachers selectTeacherNameByNum(String username){
        return allteachersMapper.selectNameByNum(username);
    }

    public int updateteacher(Allteachers teacher){
        return allteachersMapper.updateByPrimaryKey(teacher);
    }
    public void updateteacher2(AllteachersWithBLOBs teacherblobs){
        allteachersMapper.updateByPrimaryKeyWithBLOBs(teacherblobs);
    }

    public Allteachers selectByID(String nodeid){
        return allteachersMapper.selectByPrimaryKey(nodeid);
    }

    public ArrayList<Allteachers> getPage(Page<Allteachers> pages){
        return allteachersMapper.getPage(pages);
    }

    public int insertTeacher(AllteachersWithBLOBs teacherblobs){
        return allteachersMapper.insert(teacherblobs);
    }
    public void delteacherByUid(String teid){
        allteachersMapper.deleteByPrimaryKey(teid);
    }
    public ArrayList<Allteachers> selectLikeByName(String tename){
        return allteachersMapper.selectLikeByName(tename);
    }
}
