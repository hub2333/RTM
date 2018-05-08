package com.hub.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hub.entity.Nirmodel;
import com.hub.service.NirModelService;

import net.sf.json.JSONObject;

@Controller
public class PredictController {
	
	public static Nirmodel nirmodel = null;
	
	@Autowired
	@Qualifier("NirModelServiceImpl")
	public NirModelService nirModelService;
	
	
	@RequestMapping("PLS")
	private void testPLS(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		List<Nirmodel> allNirModel = nirModelService.getAllNirModel();
		nirmodel = allNirModel.get(0);
		
		//取出区间
		String interval = nirmodel.getInterval();
		//取出常数项
		Double constant = nirmodel.getConstant();
		//取出系数
		String coeff = nirmodel.getCoeff();
		
		//处理区间
		String[] split = interval.split(",");
		//最终区间索引存储在intervalReal中
		List<Integer> intervalReal = new ArrayList<Integer>();
		//遍历多个区间
		for (String item : split) {
			String[] split2 = item.split("-");
			int start = Integer.parseInt(split2[0]);
			int end = Integer.parseInt(split2[1]);
			for (int i = start; i <= end; i++) {
				intervalReal.add(i);
			}
		}
		
		//处理系数
		String[] split3 = coeff.split(",");
		List<Double> coeffReal = new ArrayList<Double>();
		for (String item : split3) {
			coeffReal.add(Double.parseDouble(item));
		}
		
		
		
		
		
		
	}
}







