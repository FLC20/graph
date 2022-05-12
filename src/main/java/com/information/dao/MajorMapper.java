package com.information.dao;

import com.information.entity.Major;
import com.information.entity.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MajorMapper {
    int deleteByPrimaryKey(String maid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(String maid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    Major selectByName(String major);

    ArrayList<Major> getPage(Page<Major> pages);

    ArrayList<Major> selectLike(String majname);
}