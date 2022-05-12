package com.information.dao;

import com.information.entity.Page;
import com.information.entity.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {
    int deleteByPrimaryKey(String plid);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(String plid);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);

    Place selectByName(String place);

    ArrayList<Place> getPage(Page<Place> pages);

    ArrayList<Place> selectLike(String plname);
}