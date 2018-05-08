package com.hub.monitor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.hub.model.ImportModel;
import com.hub.tools.CSVTools;
import com.hub.tools.SortTools;
import com.hub.websocket.MyWebSocket;

import net.sf.json.JSONObject;

public class FilesMonitor implements Runnable {
	// 文件夹路径
	public  String filePath = "";
	public  String modelPath = "";
	public static int count = 0;
	// 存放已读文件<即：缓存目录>
	//采用treemap（自动升序）的方式存放文件，以文件的修改时间作为键，（时间long越大，越近）
	private static Map<String, String> map = new HashMap<String, String>();
	
//	static {
//		
//	}
	
	public void inithub(){
		//读取配置文件
			Properties properties = new Properties();
		    // 使用ClassLoader加载properties配置文件生成对应的输入流
		    InputStream in = FilesMonitor.class.getClassLoader().getResourceAsStream("jdbc.properties");
		    // 使用properties对象加载输入流
		    try {
				properties.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //获取key对应的value值
		    String property = properties.getProperty("nirdatapath");
			System.out.println("property:"+property);
		    filePath = property;
		    
		    modelPath = properties.getProperty("currentModel");
		    System.out.println("modelPath:"+modelPath);
			//服务器刚启动的时候，先将已经存在的文件加到map中（缓存目录）
		    File files = new File(filePath);
		    File[] listFiles = files.listFiles();
		    for (File file : listFiles) {
		    	map.put(file.lastModified()+"", file.getName());
			}
			System.out.println("缓存的大小："+map.size());
	
		
	}
	
	@Override
	public void run() {
		inithub();
		while (true) {
			try {
				// 设置每隔3秒检测一次
				Thread.sleep(1000);
				FileMonitor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 文件监听
	public void FileMonitor() {
		//1.取出当前缓存的文件个数
		int cachenum = map.size();
//		System.out.println("FileMonitor缓存文件数量："+cachenum);
		//2.将文件重新加入缓存
		File files = new File(filePath);
	    File[] listFiles = files.listFiles();
	    map.clear();
	    for (File file : listFiles) {
	    	map.put(file.lastModified()+"", file.getName());
		}
	    //3.取出最新文件的个数
	    int lastnum = map.size();
//	    System.out.println("FileMonitor最新文件数量："+lastnum);
		//4.判断文件个数与缓存文件的个数差距
		int gap = lastnum - cachenum;
		//5.如果文件个数差距大于0，则开始读取新增文件
		if(gap>0) {
			//遍历新增文件
			Map<String, String> resultMap = SortTools.sortMapByKey(map);    //按Key进行排序
//			System.out.println("查看最新的文件：");
//			for (Map.Entry<String, String> entry : resultMap.entrySet()) {
//	            System.out.println(entry.getKey() + " " + entry.getValue());
//	        }
			Iterator iterator = resultMap.keySet().iterator();
			for (int i = 0; i < gap; i++) {
				iterator.hasNext();
				String item = (String)iterator.next();
				File file = new File(filePath+"/"+map.get(item));
//				System.out.println("最新文件的名字："+file.getName());
//				System.out.println("最新文件的时间："+file.lastModified());
				//获取文件绝对路径
				String absolutePath = file.getAbsolutePath();
				//从文件中抽取出光谱曲线
				String nirData = "";
				String nirWave = "";
				try {
					nirData = CSVTools.getNirData(absolutePath);
					nirWave = CSVTools.getNirWAVE(absolutePath);
				} catch (Exception e) {
					System.out.println("光谱数据读取异常");
				}
				ImportModel mo = new ImportModel();
				Double testPLS = 0.0;
				try {
					testPLS = mo.testPLS(nirData);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("预测结果:"+testPLS+"    当前时间:"+new Date());
				
				//将预测结果发送给服务器
				//群发消息
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				JSONObject jo = new JSONObject();
				//改变预测结果的精度
				DecimalFormat df = new DecimalFormat("0.00"); 
				String resultPLS = df.format(testPLS);
				//改变光谱曲线的精度
//				nirData
				String[] split = nirData.split(",");
				String nirdata2de = "";
				for (String item1 : split) {
					double parseDouble = Double.parseDouble(item1);
					nirdata2de = nirdata2de+df.format(parseDouble)+",";
				}
				
				
				jo.put("time",formatter.format(file.lastModified()));
				jo.put("predict", resultPLS);
				jo.put("nir", nirdata2de);
				jo.put("nirWave", nirWave);
		        for(MyWebSocket item1: MyWebSocket.webSocketSet){             
		            try {
		            	System.out.println("发送次数："+count++);
		                item1.sendMessage(jo.toString());
		            } catch (IOException e) {
		                e.printStackTrace();
		                continue;
		            }
		        }
				//创建对象，将光谱曲线存入数据库中
//				System.out.println("光谱数据："+nirData);
			}
			
		}
			
			
	}

	// 启动线程
	public void show() {
		FilesMonitor t = new FilesMonitor();
		Thread tread = new Thread(t);
		tread.setName("eshore");
		tread.start();
	}

//	// Main测试
//	public static void main(String[] args) {
//		FilesMonitor t = new FilesMonitor();
//		t.show();
//	}
}