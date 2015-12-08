package com.hbase.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 读取爬虫初始化的url
 * @author hun
 *
 */
public class InitUrl {
	ArrayList<String> sList=new ArrayList<String>();
	public ArrayList<String> getInitUrl(){
		try{
			Properties prop=new Properties();
			InputStream inStream=InitUrl.class.getClassLoader().getResourceAsStream("initUrl.properties");
		    prop.load(inStream);
		   
		 for(int i=1;i<prop.size()+1;i++){
			    String t=String.valueOf(i);
		    	String url=prop.getProperty(t);
		    	sList.add(url);
		    	//System.out.println(url);
		    }
		   
		
		  
		   
		}catch(Throwable e){
			//加载出错异常无法处理
			throw new ExceptionInInitializerError();
		}
		return sList;
	}


}
