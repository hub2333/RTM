package com.hub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hub.dao.NirmodelMapper;
import com.hub.entity.Nirmodel;
import com.hub.entity.NirmodelExample;
import com.hub.service.NirModelService;
@Service("NirModelServiceImpl")
public class NirModelServiceImpl implements NirModelService {

	@Autowired
	@Qualifier("nirmodelMapper")
	public NirmodelMapper nirmodelMapper;
	
	@Autowired(required = false)
	public NirmodelExample nirmodelExample;
	
	@Override
	public void insertNirModel(Nirmodel nirmodel) {
		nirmodelMapper.insertSelective(nirmodel);
	}
	
	@Override
	public void deleteNirModel(int id) {
		nirmodelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateNirModel(Nirmodel nirmodel) {
		nirmodelMapper.updateByPrimaryKeySelective(nirmodel);
	}

	@Override
	public List<Nirmodel> getAllNirModel() {
		nirmodelExample = new NirmodelExample();
		List<Nirmodel> selectByExample = nirmodelMapper.selectByExample(nirmodelExample);
		return selectByExample;
	}

}
