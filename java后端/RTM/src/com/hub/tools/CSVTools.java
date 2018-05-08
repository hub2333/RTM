package com.hub.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
 * 操作CSV文件的工具类，测试数据0-0-1
 * @author winv
 */
public class CSVTools {
	
	/**
	 * getNirData方法从目标地址获取光谱曲线数据
	 * @return
	 * @throws Exception
	 */
    public static String getNirData(String path) throws Exception {
		String nirdata = "";
//		//获取文件路径
//		URL resource = CSVTools.class.getResource("0-0-1.csv");
//		//拆分路径
//		if(resource.toString()!=null) {
//			String[] split = resource.toString().split("file:/");
//			if(split.length>1) {
//				path = split[1];
//			}
//		}
        CsvReader reader = new CsvReader(path, ',', Charset.forName("UTF-8"));
        //路过表头
        //r.readHeaders();
        //逐条读取记录，直至读完
        while (reader.readRecord()) {
            //获取当前记录位置(从0开始)
//            System.out.print(reader.getCurrentRecord() + ".");
            //读取一条记录(读取的是一行的数据)
//            System.out.println(reader.getRawRecord());
            //reader.getValues()获取一行的记录，并返回一个字符串数组
            String[] tmp = {reader.getValues()[0],reader.getValues()[1]};
            //拼接数据
            nirdata = nirdata + Float.parseFloat(reader.getValues()[1])+",";
            //
//            System.out.println("b:"+Float.parseFloat(reader.getValues()[1])+100000);
        }
        reader.close();
        nirdata = nirdata.substring(0,nirdata.length()-1);
//        System.out.println("最终数据："+nirdata);
        return nirdata;
    }
	
    
    /**
	 * getNirWAVE方法从目标地址获取光谱曲线数据的波数
	 * @return
	 * @throws Exception
	 */
    public static String getNirWAVE(String path) throws Exception {
		String nirwave = "";
        CsvReader reader = new CsvReader(path, ',', Charset.forName("UTF-8"));
        while (reader.readRecord()) {
            //拼接数据
            nirwave = nirwave + Float.parseFloat(reader.getValues()[0])+",";
        }
        reader.close();
        nirwave = nirwave.substring(0,nirwave.length()-1);
        return nirwave;
    }
}
