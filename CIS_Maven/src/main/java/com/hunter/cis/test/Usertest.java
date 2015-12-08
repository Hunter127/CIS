package com.hunter.cis.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;
import com.hunter.cis.dao.impl.ArticleDaoImpl;
import com.hunter.cis.model.Article;
import com.hunter.cis.model.Industry;
import com.hunter.cis.model.User;
import com.hunter.cis.service.PageService;
import com.hunter.cis.service.SolrService;
import com.hunter.cis.service.UserService;


public class Usertest {
	private ApplicationContext ctx=null;
	private UserService us=null;
	private SolrService ss=null;
	private PageService ps=null;

	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		us=ctx.getBean(UserService.class);
		ss=ctx.getBean(SolrService.class);
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

	@Test
	public void Jiexi(){
		List<Map<String, String>> a = dao.CUSScan("家具", table, "maintab");
		for (Map<String, String> map : a) {
			String x = map.get("title");
			String y = map.get("description");
			String z = map.get("context");
			Article ar=new Article();
			ar.setContent(z);
			//ar.setFromUrl(fromUrl);
		}
	}
	
	/**
	 * 增加一位关注金融行业的用户
	 */
	@Test
	public void addUser(){
		User user=new User();
		Industry indus=new Industry();
		indus.setName("金融");
		
		user.setUsername("11111");
		user.setPassword("123");
		user.setTel("15677098116");
		Date a = new Date(new java.util.Date().getTime());
		user.setCreateTime(a);
		user.setLastTime(a);
		user.setEmail("874897975@qq.com");
		
		user.setIndustry(indus);
         us.register(user);
		
		
	}
	
	@Test
	public void TestLogin(){
		User u=new User();
		
		u.setUsername("11111");
		u.setPassword("123");
		
		System.out.println(us.login(u).toString());
		
		
	}
	@Test
	public void TestChangepassword(){
		User u=new User();
		
		u.setUsername("11111");
		u.setPassword("123");
		
		System.out.println(us.rePassword(u, "123456"));
		
		
	}
	@Test
	public void TestAddArticle(){
		Article a=new Article();
		Industry industry=new Industry();
		industry.setName("医药");
		a.setContent("内容");
		a.setFromUrl("url");
		Date a1 = new Date(new java.util.Date().getTime());
		a.setCreateTime(a1);
		a.setIndustry(industry);
		a.setKeywords("关键词");
		a.setTitle("标题");
		ps.Add(a);
		
	}
	@Test
	public void TestDelectArt(){
		ps.delectArt(2);
	}
	
	/**
	 *  测试c3p0数据源
	 * @throws Exception
	 */
	@Test
	public void testDataSource() throws Exception{
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
