package com.information.service.impl;

import com.information.dao.LinksMapper;
import com.information.entity.Links;
import com.information.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("LinksService")
public class LinksServiceImpl implements LinksService {
    @Autowired
    private LinksMapper linksMapper;
    public ArrayList<Links> selectAll(){
        return linksMapper.selectAll();
    }
    public Links selectLinkAll(){
        return linksMapper.selectLinkAll();
    }
    public ArrayList<Links> selectLinByUID(String teid){
        return linksMapper.selectBySourceId(teid);
    }
    public void updatelinkByID(int id,String sid,String fid){linksMapper.updateByID(id,sid,fid);}
    public Links selectByIDandVal(String teid, String val){return linksMapper.selectByIDAndVal(teid,val);}
    public void addlink(String stid, String maid, String val){linksMapper.insertLink(stid,maid,val);}
    public void delLinkByUid(String stid){linksMapper.delLinkByID(stid);}
    public void delLinkByUidAndVal(String teid, String val){linksMapper.delLinkByUIDAndVAL(teid,val);}
}
