package com.information.service;

import com.information.entity.Major;
import com.information.entity.Page;

import java.util.ArrayList;

public interface MajorService {
    Major selectByName(String major);

    ArrayList<Major> getPage(Page<Major> pages);

    int insetMa(Major major);

    void delMaByMaid(String maid);

    ArrayList<Major> selectLike(String majname);
}
