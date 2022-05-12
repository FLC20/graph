package com.information.dao;

import com.information.entity.Use2iden;
import com.information.entity.Use2idenKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Use2idenMapper {
    int deleteByPrimaryKey(Use2idenKey key);

    int insert(Use2iden record);

    int insertSelective(Use2iden record);

    Use2iden selectByPrimaryKey(Use2idenKey key);

    int updateByPrimaryKeySelective(Use2iden record);

    int updateByPrimaryKey(Use2iden record);
}