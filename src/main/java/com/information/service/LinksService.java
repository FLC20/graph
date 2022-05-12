package com.information.service;

import com.information.entity.Links;

import java.util.ArrayList;

public interface LinksService {
    ArrayList<Links> selectAll();

    Links selectLinkAll();

    ArrayList<Links> selectLinByUID(String teid);

    void updatelinkByID(int id,String sid,String fid);

    Links selectByIDandVal(String teid, String val);

    void addlink(String stid, String maid, String val);

    void delLinkByUid(String stid);

    void delLinkByUidAndVal(String teid, String val);
}
