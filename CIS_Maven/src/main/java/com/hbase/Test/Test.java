package com.hbase.Test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hbase.Dao.DataDAO;
/**
 * use to test Hbase
 * @author hun
 *
 */
public class Test {
	/*public static void main(String[] args){
		DataDAO dao=com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
		//dao.Create("Crawler", "info");
		dao.delect("Crawler");
	//	String t="<h1>(.*?)<\/h1>";
	//	String t1="\<\bdiv.*\<\/div\b\>";
	//	String t2="\<.[^<>]*\>";
		
		String i="/<(h1)\s*[^<>]*>[^<>]*<\/\1\s*>/ig";
		String h1="\<\bh1.*\<\/h1\b\>";
		String p="\<\bp.*\<\/p\b\>";
	}*/

	public static void main(String[] args) {
	   // String str = "<p class='xxxx'> Content\n\r内容\t\n\n</p>";
	   /* String str="";
	    Matcher m = Pattern.compile("<p.*?>([\\s\\S]*)</p>").matcher(str);
	    while(m.find()){
	        System.out.println(m.group(1));
	    }*/
		String str="qwer2012";
		
		if(str.contains("2012")){
			System.out.println("真的包含啊");
		}else{
		System.out.println("fuck，没有");
		}
	}
}
