package com.information.service.impl;

import com.information.dao.NodesMapper;
import com.information.entity.Nodes;
import com.information.service.NodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("NodesService")
public class NodesServiceImpl implements NodesService {
    @Autowired
    private NodesMapper nodesMapper;
    public ArrayList<Nodes> selectAll(){
        return nodesMapper.selectAll();
    }
    public Nodes selectNodeAll(){
        return nodesMapper.selectNodeAll();
    }
    public Nodes selectNodeByName(String name){
        return nodesMapper.selectByName();
    }
    public Nodes selectByUID(String uid){
        return nodesMapper.selectByPrimaryKey(uid);
    }
    public void insertNodes(String nodeid, String name, int symbolSize, int category){
        nodesMapper.insertNodes(nodeid,name,symbolSize,category);
    }
    public void delNodes(String stid){
        nodesMapper.deleteByPrimaryKey(stid);
    }
}
