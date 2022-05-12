package com.information.service.impl;

import com.information.dao.AllnodesMapper;
import com.information.service.AllnodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.information.entity.Allnodes;

@Service("AllnodesService")
public class AllnodesServiceImpl implements AllnodesService {
    @Autowired
    private AllnodesMapper allnodesMapper;
    public Allnodes selectNodeByName(String name){
        return allnodesMapper.selectByName(name);
    }
    public Allnodes selectByUID(String uid){return allnodesMapper.selectByUID(uid);}
    public void insertAllnodes(String allnodeid, String uid, String name, int symbolSize, int category){
        allnodesMapper.insertAllnodes(allnodeid,uid,name,symbolSize,category);
    }
    public void delAllnodes(String stid){
        allnodesMapper.deleteByPrimaryKey(stid);
    }

}
