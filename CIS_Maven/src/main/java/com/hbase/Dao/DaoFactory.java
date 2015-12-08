package com.hbase.Dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static DataDAO dataDAO=null;
	/**
	 * 单例模式，直接加载
	 */
	private static DaoFactory instance=new DaoFactory();
	
	private DaoFactory(){
		try{
			Properties prop=new Properties();
			InputStream inStream=DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
		    prop.load(inStream);
		    String dataDaoClass=prop.getProperty("key");
		    Class clazz=Class.forName(dataDaoClass);
		    dataDAO=(DataDAO) clazz.newInstance();
		}catch(Throwable e){
			//加载出错异常无法处理
			throw new ExceptionInInitializerError();
		}
	}
 public static DaoFactory getInstance(){
	 return instance;
 }
 public DataDAO getdataDAo(){
	 return dataDAO;
 }
}
