package com.information.dao;

import com.information.entity.Department;
import com.information.entity.DepartmentWithBLOBs;
import com.information.entity.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(String deid);

    int insert(DepartmentWithBLOBs record);

    int insertSelective(DepartmentWithBLOBs record);

    DepartmentWithBLOBs selectByPrimaryKey(String deid);

    int updateByPrimaryKeySelective(DepartmentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DepartmentWithBLOBs record);

    int updateByPrimaryKey(Department record);

    Department selectByName(String department);

    ArrayList<Department> getPage(Page<Department> pages);

    ArrayList<Department> selectLike(String dename);
}