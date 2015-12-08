package com.hbase.Parsing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;

/**
 * 在已有数据的情况下进行数据处理，，进行文本解析
 * 这里不能调用已有scan函数，，要重写，内存可能个问题
 * @author hun
 *
 */
public class Parsing {
	
	public static void main(String[] args) {
		Parsing ping=new Parsing();
		//DataDAO dao = Back.com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
		//dao.Create("Text", "info");
		/*Table table=null; 
		try {
		 table = HbaseUtil.getHbasecon().getTable(
					TableName.valueOf("UrlData"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//ping.ToParsing("UrlData", table);
		/*Document document = null;
		try {
			document = Jsoup.connect("http://news.jia360.com/weiyu/20150721/1437444169722.html").get();
			//document = Jsoup.connect("http://www.chinairn.com/news/20150721/140553955.shtml").data("query", "Java").userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		ping.ScanSome();
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

	}

	/**
	 * 拦截在http网
	 * @param str
	 * @return
	 */
	public static boolean Fiterjinji(String str) {

		String regEx = "<a href=\"http://www.";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	public int ToParsing(String tableName,Table table) {
		StringBuffer sb = new StringBuffer();
		 int n=0;
		String string=null;
		 try{   
             Scan s = new Scan();  
             ResultScanner ss = table.getScanner(s);  
           
             for(Result r:ss){  
                 for(KeyValue kv : r.raw()){ 
                	string = new String(kv.getRow());
                   // System.out.print(string + " ");  
                   //.out.print(new String(kv.getFamily()) + ":");  
                  //  System.out.print(new String(kv.getQualifier()) + " ");  
                  //  System.out.print(kv.getTimestamp() + " ");  
                  //  System.out.println(new String(kv.getValue()));  
                	//System.out.println("0");
                	if("context".equals(new String(kv.getQualifier()))){
                		String t=new String(kv.getValue());
                		Map<String, String> map = jiexi(t);
                		Insert(map,string);
                	}
                		
                 }  
                 if(string!=null){
                	 sb.append(string+"\n\r");
                	 n++;
                 }
                 
                 
             }
             
        } catch (IOException e){  
            e.printStackTrace();  
        }
		return n;  

	}
	private void Insert(Map<String, String> map, String Rowkey) {
		
		String tablename = "Text";
		String CF="info";
		try {
			Table table = HbaseUtil.getHbasecon().getTable(
					TableName.valueOf(tablename));
			//Table table = HbaseUtil.getHbasecon().getTable(TableName.valueOf(tableName));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			String t = df.format(new Date());
		    Put p=new Put(Bytes.toBytes(t+Rowkey));
		    p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("h"), Bytes.toBytes(map.get("h")));
		    p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("p"), Bytes.toBytes(map.get("p")));
		    table.put(p);
		  System.out.println("插入成功");
		   // table.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ScanSome(){
		StringBuffer sb = new StringBuffer();
		 int n=0;
		String string=null;
		 try{  Table table = HbaseUtil.getHbasecon().getTable(
					TableName.valueOf("Text"));
            
            Scan s = new Scan();  
           
            ResultScanner ss = table.getScanner(s);  
           
           // StringBuffer sb1 = null;
            for(Result r:ss){  
            	//string =new String(r.getRow());
            	
            	//System.out.println(string);
            	//System.out.println();
                for(KeyValue kv : r.raw()){ 
               	string = new String(kv.getRow());
                 System.out.print(string + " "+string.length());  
                  //.out.print(new String(kv.getFamily()) + ":");  
                 //  System.out.print(new String(kv.getQualifier()) + " ");  
                 System.out.println(" "+kv.getTimestamp() + " ");  
                 //  System.out.println(new String(kv.getValue()));  
               
               		
                }  
                if(string!=null){
               	 sb.append(string+"\n\r");
               	 n++;
                }
                
                
            }
            
       } catch (IOException e){  
           e.printStackTrace();  
       }
	
	}

	public static Map<String, String> jiexi(String t){
		Map<String, String> map=new HashMap<String,String>();
		Document doc = Jsoup.parse(t);
		 String title=doc.title();
		 Elements h1 = doc.getElementsByTag("h1");
			//System.out.println(h1.text());
			Elements p1 = doc.getElementsByTag("p");
			StringBuffer sb=new StringBuffer();
			for(Element s:p1){
				//尽可能提取到文本内容
				if(s.text().length()>10){
				sb.append(s.text()+"\n\r");
			}
			}
			map.put("h", h1.text());
			map.put("p", sb.toString());
		return map;
		
	}

}
