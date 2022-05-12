package com.information.service.impl;

import com.information.dao.DepartmentMapper;
import com.information.entity.Department;
import com.information.entity.DepartmentWithBLOBs;
import com.information.entity.Page;
import com.information.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public Department selectByName(String department){
        return departmentMapper.selectByName(department);
    }
    public DepartmentWithBLOBs selectByID(String nodeid){
        return departmentMapper.selectByPrimaryKey(nodeid);
    }
    public ArrayList<Department> getPage(Page<Department> pages){
        return departmentMapper.getPage(pages);
    }
    public int insertDe(DepartmentWithBLOBs department){
        return departmentMapper.insert(department);
    }
    public int updateDe(DepartmentWithBLOBs department){
        return departmentMapper.updateByPrimaryKeyWithBLOBs(department);
    }
    public void delDepByDeid(String deid){
        departmentMapper.deleteByPrimaryKey(deid);
    }
    public ArrayList<Department> selectLike(String dename){
        return departmentMapper.selectLike(dename);
    }
}
