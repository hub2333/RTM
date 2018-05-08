package com.hub.tools;

import java.io.File;

public class Test1 {

	//测试程序,查看异常样本的文件名
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\winv\\Desktop\\data");
		File[] listFiles = file.listFiles();
		int arr[] = {7,8 ,37 ,38 ,60 ,61, 62 ,63, 90 ,91 ,100 ,101 ,162, 244 ,245};
		for (int item : arr) {
			System.out.println(listFiles[item-1].getName());
			
		}
		
	}
}
