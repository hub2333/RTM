package com.hub.service;

import java.util.List;

import com.hub.entity.Nirmodel;


public interface NirModelService {

	//增
	public void insertNirModel(Nirmodel nirmodel);
	//删
	public void deleteNirModel(int id);
	//改
	public void updateNirModel(Nirmodel nirmodel);
	//查
	public List<Nirmodel> getAllNirModel();
	
	
}
