package com.hbase.Parsing;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hbase.Dao.DataDAO;
import com.hbase.Dao.impl.DataDAOImpl;
import com.hbase.utils.HbaseUtil;
import com.hunter.cis.model.Article;
import com.hunter.cis.model.Industry;
import com.hunter.cis.service.PageService;
import com.hunter.cis.service.SolrService;
import com.hunter.cis.service.UserService;

public class ParsingToMysql {
	private ApplicationContext ctx=null;
	
	private PageService ps=null;

	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ps=ctx.getBean(PageService.class);
	}
	///////////////////////////////////////////////////////
	
	Table table = null;
	String tablename="Data";
	private  DataDAO dao;

	@Before
	public void setUp() throws Exception {
		table = HbaseUtil.getHbasecon().getTable(TableName.valueOf(tablename));
		dao=com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
	}

	///////////////////////////////////////////////
	    /**
	     * 解析那个行业，解析文本处的id是什么
	     */
	    @org.junit.Test
		public  void Test1(){
			List<Map<String, String>> a = dao.CUSScan("通信", table,"text1");
			Industry indus=new Industry();
			indus.setName("通信");
			//System.out.println(a.size());
			
			//System.out.println(a.toString());
			for (Map<String, String> map : a) {
				/*System.out.println(map.get("title")+"aaaaaaaaaaaaaaaaaaaaaaaaa");
				System.out.println(map.get("url")+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
				System.out.println(map.get("context")+"cccccccccccccccccc");
				System.out.println(map.get("description")+"ddddddddddddddddddddddddddd");
				*/
				if(map.get("title")!=null&&map.get("url")!=null&&map.get("context")!=null&&map.get("description")!=null){
				System.out.println(map.get("url"));
				Article ar=new Article();
				ar.setContent(map.get("context"));
				Date a1 = new Date(new java.util.Date().getTime());
				ar.setCreateTime(a1);
				ar.setFromUrl(map.get("url"));
				System.out.println(map.get("url")+"11111111111111111111111111111111111111111111");
				ar.setIndustry(indus);
				ar.setKeywords(map.get("description"));
				ar.setTitle(map.get("title"));
			
				ps.Add(ar);
				}
			}
		}
	
	   

}
