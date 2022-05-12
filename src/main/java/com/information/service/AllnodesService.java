package com.information.service;

import com.information.entity.Allnodes;

public interface AllnodesService {
    Allnodes selectNodeByName(String name);

    Allnodes selectByUID(String uid);

    void insertAllnodes(String allnodeid, String uid, String name, int symbolSize, int category);

    void delAllnodes(String stid);
}
