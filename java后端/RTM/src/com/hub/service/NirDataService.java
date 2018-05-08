package com.hub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hub.entity.NirdataWithBLOBs;


public interface NirDataService {

	//增
	public void insertNirData(NirdataWithBLOBs nirdata);
	//删
	public void deleteNirData(int id);
	//改
	public void updateNirData(NirdataWithBLOBs nirdata);
	//查
	public List<NirdataWithBLOBs> getAllNirData();
	
}
