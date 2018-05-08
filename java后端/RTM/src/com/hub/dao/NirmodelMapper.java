package com.hub.dao;

import com.hub.entity.Nirmodel;
import com.hub.entity.NirmodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NirmodelMapper {
    int countByExample(NirmodelExample example);

    int deleteByExample(NirmodelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nirmodel record);

    int insertSelective(Nirmodel record);

    List<Nirmodel> selectByExampleWithBLOBs(NirmodelExample example);

    List<Nirmodel> selectByExample(NirmodelExample example);

    Nirmodel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nirmodel record, @Param("example") NirmodelExample example);

    int updateByExampleWithBLOBs(@Param("record") Nirmodel record, @Param("example") NirmodelExample example);

    int updateByExample(@Param("record") Nirmodel record, @Param("example") NirmodelExample example);

    int updateByPrimaryKeySelective(Nirmodel record);

    int updateByPrimaryKeyWithBLOBs(Nirmodel record);

    int updateByPrimaryKey(Nirmodel record);
}