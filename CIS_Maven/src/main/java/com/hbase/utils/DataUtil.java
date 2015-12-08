package com.hbase.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hunter.cis.dao.impl.ArticleDaoImpl;
import com.hunter.cis.model.Article;
import com.hunter.cis.model.Industry;



/**
 * 用了spring，数据库的事物管理，都由它控制，new是没有用了会得不到session的。
 * @author hun
 *
 */
public class DataUtil {
	
	
	private static ArticleDaoImpl test=new ArticleDaoImpl();
	/**
	 * 将解析后的数据存进mysql
	 * @param url
	 * @param map
	 * @param string ,这个参数暂时没有
	 */
	public static void SaveTomysql( String url, Map<String, String> map,
		String string){
		
		if(map.get("description")==null||map.get("keywords")==null||map.get("title")==null){
			return;
		}
		Article a=new Article();
		Industry industry=new Industry();
		industry.setName("硬件");   //这次只存有关家具的信息
		a.setContent(map.get("description"));
		a.setFromUrl(url);
		Date a1 = new Date(new java.util.Date().getTime());
		a.setCreateTime(a1);
		a.setIndustry(industry);
		a.setKeywords(map.get("keywords"));
		a.setTitle(map.get("title"));
		test.Add(a);
		
		
		
	}
	/**
	 * 将web网页数据存储在本地
	 * @param t
	 * @param s
	 */
	public static void save(String t, int s) {
		try {
			String file = "D:\\1234/" + s + ".shtml";
			OutputStreamWriter outs = new OutputStreamWriter(
					new FileOutputStream(file, true), "utf-8");
			outs.write(t);
			System.out.println("第"+s+"写入成功");
		/*	long end = System.currentTimeMillis();
			System.out.println("鎬诲叡鑰楁椂" + (end - start) / 1000 + "绉�");*/
			//System.out.println(end);
			outs.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 拦截在经济网，股票
	 * @param str
	 * @return
	 */
	public static boolean Fiterjinji(String str) {

		String regEx = "http://stock.cngold.org";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 拦截在硬件网
	 * @param str
	 * @return
	 */
	public static boolean FiterY(String str) {

		String regEx = "http://furniture.liwai.com/";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 拦截在电商网
	 * @param str
	 * @return
	 */
	public static boolean FiterD(String str) {

		String regEx = "http://www.ebrun.com/";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 拦截在家具网内
	 * @param str
	 * @return
	 */
	public static boolean Fiterjiaju(String str) {

		String regEx = "http://news.jc001.cn";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 拦截在IT网内
	 * @param str
	 * @return
	 */
	public static boolean FiterIT(String str) {

		String regEx = "http://www.csdn.net/";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 拦截在IT网内
	 * @param str
	 * @return
	 */
	public static boolean FiterT(String str) {

		String regEx = "http://www.c114.net/";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		return result;
	}
	/**
	 * 把没有时效性的东西，去除掉。同时这样做也达到一个功能，，就是最终只保存了html的文本文件
	 * @param str
	 * @return
	 */
	public static boolean Fiter(String str){
		boolean t=false;
		if(str.contains("/content")){
			return true;
		}
		return t;
	}
	public static void saveToHbase(String t, String tmp) {
		
		
	}
	/**
	 * 保存主键
	 * @param keys
	 */
	public static void saveKey(String keys){
		try {
			String file = "D:\\1234/key.text";
			OutputStreamWriter outs = new OutputStreamWriter(
					new FileOutputStream(file, true), "utf-8");
			outs.write(keys);
			System.out.println("关键词写入成功");
		/*	long end = System.currentTimeMillis();
			System.out.println("鎬诲叡鑰楁椂" + (end - start) / 1000 + "绉�");*/
			//System.out.println(end);
			outs.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
