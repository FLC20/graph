package com.information.dao;

import com.information.entity.Links;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
@Mapper
public interface LinksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Links record);

    int insertSelective(Links record);

    Links selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Links record);

    int updateByPrimaryKey(Links record);

    ArrayList<Links> selectAll();

    Links selectLinkAll();

    ArrayList<Links> selectBySourceId(String teid);

    void updateByPrimaryKey(int id);

    void updateByID(@Param("id") int id,@Param("sid") String sid,@Param("fid") String fid);

    Links selectByIDAndVal(@Param("teid") String teid,@Param("val") String val);

    void insertLink(@Param("stid")String stid,@Param("maid") String maid,@Param("val") String val);

    void delLinkByID(String stid);

    void delLinkByUIDAndVAL(@Param("teid") String teid,@Param("val") String val);
}