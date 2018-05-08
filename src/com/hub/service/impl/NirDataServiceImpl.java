package com.hub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hub.dao.NirdataMapper;
import com.hub.entity.NirdataExample;
import com.hub.entity.NirdataWithBLOBs;
import com.hub.service.NirDataService;
@Service("NirDataServiceImpl")
public class NirDataServiceImpl implements NirDataService {

	@Autowired
	public NirdataMapper nirdataMapper;
	
	@Autowired(required = false)
	public NirdataExample nirdataExample;
	
	@Override
	public void insertNirData(NirdataWithBLOBs nirdata) {
		// TODO Auto-generated method stub
		nirdataMapper.insert(nirdata);
	}

	@Override
	public void deleteNirData(int id) {
		// TODO Auto-generated method stub
		nirdataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateNirData(NirdataWithBLOBs nirdata) {
		// TODO Auto-generated method stub
		nirdataMapper.updateByPrimaryKey(nirdata);
	}
	
	@Override
	public List<NirdataWithBLOBs> getAllNirData() {
		// TODO Auto-generated method stub
		nirdataExample = new NirdataExample();
		List<NirdataWithBLOBs> selectByExampleWithBLOBs = nirdataMapper.selectByExampleWithBLOBs(nirdataExample);
		return selectByExampleWithBLOBs;
	}


}
