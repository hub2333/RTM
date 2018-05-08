package com.hub.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csvreader.CsvReader;
import com.hub.dao.CustomDao;
import com.hub.entity.Nirmodel;
import com.hub.service.NirModelService;
import com.hub.service.impl.NirModelServiceImpl;
import com.hub.tools.CSVTools;

/**
 * 导入模型工具
 * 模型包含的参数有：
 * 1. 1492中若干个特征的索引
 * 2. 索引的系数以及常数项
 * @author winv
 *
 */
public class ImportModel {
	//存储模型的位置
	public static String modelPath = "model1.csv";
	//导入模型
	//注意模型的格式：
	//第一行是区间划分
	//第二行是常数项
	//第三行是系数
	public static Nirmodel useModel() throws Exception {
		Nirmodel currentmodel = new Nirmodel();
		String interval = "";
		String constant = "";
		String coeff = "";
		String path = "";
		//获取文件路径
		URL resource = ImportModel.class.getResource(modelPath);
//		System.out.println("a:"+resource);
		//拆分路径
		if(resource.toString()!=null) {
			String[] split = resource.toString().split("file:/");
			if(split.length>1) {
				path = split[1];
			}
		}
		try {
			CsvReader reader = new CsvReader(path, ',', Charset.forName("UTF-8"));
			int row = 0;//一共三行
			while (reader.readRecord()) {
				if(row==0) {//第一行，获取区间
					String rawRecord = reader.getRawRecord();
					currentmodel.setInterval(rawRecord);
//					System.err.println("第一行数据："+rawRecord);
					row++;
				}else if(row == 1) {//第二行，获取常数项
					String rawRecord = reader.getRawRecord();
					currentmodel.setConstant(Double.parseDouble(rawRecord));
					row++;
				}else if(row == 2) {//第三行，获取所有的系数
					String rawRecord = reader.getRawRecord();
					currentmodel.setCoeff(rawRecord);
				}
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //将对象填充到数据库中
		currentmodel.setModelname("SiPLS模型");
		currentmodel.setTime(new Date());
		currentmodel.setUploader("hub");
		
		return currentmodel;
	}
	
	
	//
	public Double testPLS(String nirData) throws Exception{
		
		Nirmodel nirmodel = ImportModel.useModel();
		
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
		
//		//输出变量索引看看
//		System.out.println("变量索引：");
//		for (int item : intervalReal) {
//			System.out.print(item+",");
//		}
		
		
		String[] split4 = nirData.split(",");
		Double result = constant;
//		System.out.println("变量：");
		int index = 0;
		for (Integer item : intervalReal) {
			Double temp = Double.parseDouble(split4[item-1]);
//			System.out.print(split4[item-1]+",");
			result = result+temp*coeffReal.get(index++);
		}
//		System.out.println("变量个数："+intervalReal.size());
//		System.out.println("常数项是："+constant);
		return result;
		
	}
}
