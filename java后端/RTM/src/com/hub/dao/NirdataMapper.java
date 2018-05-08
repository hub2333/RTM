package com.hub.dao;

import com.hub.entity.Nirdata;
import com.hub.entity.NirdataExample;
import com.hub.entity.NirdataWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface NirdataMapper {
    int countByExample(NirdataExample example);

    int deleteByExample(NirdataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NirdataWithBLOBs record);

    int insertSelective(NirdataWithBLOBs record);

    List<NirdataWithBLOBs> selectByExampleWithBLOBs(NirdataExample example);

    List<Nirdata> selectByExample(NirdataExample example);

    NirdataWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NirdataWithBLOBs record, @Param("example") NirdataExample example);

    int updateByExampleWithBLOBs(@Param("record") NirdataWithBLOBs record, @Param("example") NirdataExample example);

    int updateByExample(@Param("record") Nirdata record, @Param("example") NirdataExample example);

    int updateByPrimaryKeySelective(NirdataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NirdataWithBLOBs record);

    int updateByPrimaryKey(Nirdata record);
}