package com.information.service;

import com.information.entity.Page;
import com.information.entity.Schools;

import java.util.ArrayList;

public interface SchoolsService {
    Schools selectByName(String school);

    ArrayList<Schools> getPage(Page<Schools> pages);

    int insertSc(Schools schools);

    int updateSc(Schools schools);

    void delScByScid(String scid);

    ArrayList<Schools> selectLike(String scname);
}
