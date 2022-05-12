package com.information.service;

import com.information.entity.Department;
import com.information.entity.DepartmentWithBLOBs;
import com.information.entity.Page;

import java.util.ArrayList;

public interface DepartmentService {
    Department selectByName(String department);

    DepartmentWithBLOBs selectByID(String nodeid);

    ArrayList<Department> getPage(Page<Department> pages);

    int insertDe(DepartmentWithBLOBs department);

    int updateDe(DepartmentWithBLOBs department);

    void delDepByDeid(String deid);

    ArrayList<Department> selectLike(String dename);
}
