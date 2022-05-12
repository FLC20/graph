package com.information.service;

import com.information.entity.Nodes;

import java.util.ArrayList;

public interface NodesService {
    ArrayList<Nodes> selectAll();

    Nodes selectNodeAll();

    Nodes selectNodeByName(String name);

    Nodes selectByUID(String uid);

    void insertNodes(String nodeid, String name, int symbolSize, int category);

    void delNodes(String stid);
}
