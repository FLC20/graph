package com.information.service.impl;

import com.information.dao.MajorMapper;
import com.information.entity.Major;
import com.information.entity.Page;
import com.information.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MajorService")
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    public Major selectByName(String major){
        return majorMapper.selectByName(major);
    }
    public ArrayList<Major> getPage(Page<Major> pages){return majorMapper.getPage(pages);}
    public int insetMa(Major major){return majorMapper.insert(major);}
    public void delMaByMaid(String maid){majorMapper.deleteByPrimaryKey(maid);}
    public ArrayList<Major> selectLike(String majname){return majorMapper.selectLike(majname);}

}
