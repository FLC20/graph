package com.information.service.impl;

import com.information.dao.SchoolsMapper;
import com.information.entity.Page;
import com.information.entity.Schools;
import com.information.service.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("SchoolServiceImpl")
public class SchoolsServiceImpl implements SchoolsService {
    @Autowired
    private SchoolsMapper schoolsMapper;
    public Schools selectByName(String school){
        return schoolsMapper.selectByName(school);
    }
    public ArrayList<Schools> getPage(Page<Schools> pages){return schoolsMapper.getPage(pages);}
    public int insertSc(Schools schools){return schoolsMapper.insert(schools);}
    public int updateSc(Schools schools){return schoolsMapper.updateByPrimaryKey(schools);}
    public void delScByScid(String scid){schoolsMapper.deleteByPrimaryKey(scid);}
    public ArrayList<Schools> selectLike(String scname){return schoolsMapper.selectLike(scname);}
}
