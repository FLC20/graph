package com.information.service.impl;

import com.information.dao.PlaceMapper;
import com.information.entity.Page;
import com.information.entity.Place;
import com.information.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;
    public Place selectByName(String place){
        return placeMapper.selectByName(place);
    }
    public ArrayList<Place> getPage(Page<Place> pages){return placeMapper.getPage(pages);}
    public int insertPl(Place place){return placeMapper.insert(place);}
    public void delPlByPlid(String plid){placeMapper.deleteByPrimaryKey(plid);}
    public ArrayList<Place> selectLike(String plname){return placeMapper.selectLike(plname);}
}
