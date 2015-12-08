package com.Crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.DataUtil;
import com.hbase.utils.HbaseUtil;

/**
 * 
 * 爬虫的具体实现，爬来的数据不要存进mysql，存进hbase，提取后在存进mysql
 * 
 * @author hun
 *
 */
public class Spider {
	public ArrayList<String> allurlSet = new ArrayList<String>();
	public ArrayList<String> notCrawlurlSet = new ArrayList<String>();
	HashMap<String, Integer> depth = new HashMap<String, Integer>();
	private DataDAO dao = com.hbase.Dao.DaoFactory.getInstance().getdataDAo();

	public int count = 0;
	public static final Object signal = new Object(); 
	int s = 0;
	Table table = null;
	String tablename = "Data"; 
	
	
	public Table getTable(){
		Table t;
		try {
			  t=HbaseUtil.getHbasecon().getTable(
					TableName.valueOf(tablename));
			  return t;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public void Threads(int d,int i){
		new Thread(new Runnable() {
			public void run() {
				
				while (true) {    //线程不死就会循环下一个网站
					/*if(Thread.activeCount()<8){
						Threads(d, i);
					}*/
					String url = getAUrl();
					if (url != null) {
						String content = crawler(url, d);
							synchronized (signal) {
								s++;
								if (DataUtil.Fiter(url)) {  //针对每个网址都要不同的过路代码来过滤url
									//dao.Puted(tablename, table, url, content);
									DataUtil.save(content, s);
								}
							}
							} else {
						synchronized (signal) {
							try {
								count++;
								signal.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				}
			}
		}, "thread-" + i).start();
	}
	/**
	 * Thread Start...
	 */
	public void begin(int d, int threadCount, long start,String name) {
		table=getTable();
		if(dao.IsExist(tablename)==false){
			dao.Create(tablename, "info");
		}

		for (int i = 0; i < threadCount; i++) {
			//Threads(d, i);
			new Thread(new Runnable() {
				public void run() {
					
					while (true) {    //线程不死就会循环下一个网站
						/*if(Thread.activeCount()<8){
							Threads(d, i);
						}*/
						String url = getAUrl();
						if (url != null) {
							String content = crawler(url, d);
								synchronized (signal) {
									s++;
									if (DataUtil.Fiter(url)) {  //针对每个网址都要不同的过路代码来过滤url,用列族的列来分类
										dao.Puted(tablename, table,name, url, content);
										//DataUtil.save(content, s);
									}
								}
								} else {
							synchronized (signal) {
								try {
									count++;
									signal.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

						}
					}
				}
			}, "thread-" + i).start();
		
		}
		
		try {
			table.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 存进hbase，应该不解析这么多
	 * 
	 * @param t
	 * @return
	 */
	// 解析web文本，包括它的title，description，keywords，
	protected Map<String, String> jiexi(String t) {

		Map<String, String> maps = new HashMap<String, String>();
		Document doc = Jsoup.parse(t);
		String title = doc.title();
		maps.put("title", title);
		Element head = doc.head();
		Elements metas = head.select("meta");
		for (Element meta : metas) {
			// String content = meta.attr("content");
			if ("description".equalsIgnoreCase(meta.attr("name"))
					|| "keywords".equalsIgnoreCase(meta.attr("name"))) {
				maps.put("description", meta.attr("content"));
				maps.put("keywords", meta.attr("content"));

			}
		}
		return maps;
	}


	public synchronized String getAUrl() {
		if (notCrawlurlSet.isEmpty())
			return null;
		String Url;
		Url = notCrawlurlSet.get(0);  //没有爬取的集合中取出一条数据
		notCrawlurlSet.remove(0);     //然后去除数据

		return Url;
	}

	

	/**
	 * Crawler sUrl
	 * @param sUrl
	 * @return
	 */
	public String crawler(String sUrl, int crawDepth) {
		URL url;
		StringBuffer sb = null;
		String charset = "gb2312";
		try {
			url = new URL(sUrl);
			URLConnection urlconnection = url.openConnection();   //httpclient对URLConnection进行了二次封装，还有这个有不足。httpclient性能更好
			urlconnection.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			InputStream is = url.openStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					is, "utf-8"));
			sb = new StringBuffer();
			String rLine = null;
			while ((rLine = bReader.readLine()) != null) {
				sb.append(rLine);
			}
			int d = depth.get(sUrl);
			if (d < crawDepth) {
				parseContext(sb.toString(), d + 1);   //解析web文本得到url
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 解析文本获得url
	 * @param context
	 * @param dep
	 */
	public void parseContext(String context, int dep) {
		String regex = "<a .*?/a>";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(context);
		while (mt.find()) {
			Matcher myurl = Pattern.compile("href=\".*?\"").matcher(mt.group());
			while (myurl.find()) {
				String str1 = myurl.group().replaceAll("href=\"|\"", "");
				//System.out.println(str);
				String str="http://furniture.liwai.com/"+str1;
				// 每一个网站必改的地方
				if (DataUtil.FiterY(str)) {

					if (!allurlSet.contains(str)) {
						addUrl(str, dep);// increase url

						if (count > 0) { // if have the wait thread ,call up it
							synchronized (signal) { 
								count--;
								signal.notify();
							}
						}
					}
				}

			}
		}

	}
	
	public synchronized void addUrl(String url, int d) {
		notCrawlurlSet.add(url);
		allurlSet.add(url);
		depth.put(url, d);
	}

}
