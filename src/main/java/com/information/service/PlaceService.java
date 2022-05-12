package com.information.service;

import com.information.entity.Page;
import com.information.entity.Place;

import java.util.ArrayList;

public interface PlaceService {
    Place selectByName(String place);

    ArrayList<Place> getPage(Page<Place> pages);

    int insertPl(Place place);

    void delPlByPlid(String plid);

    ArrayList<Place> selectLike(String plname);
}
