package com.hbase.Test;

import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;

public class TestHbase {
	
	
	Table table = null;
	String tablename="Data";
	private  DataDAO dao;

	@Before
	public void setUp() throws Exception {
		table = HbaseUtil.getHbasecon().getTable(TableName.valueOf(tablename));
		dao=com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestListTable() {
		List<String> a = dao.ListALLTable();
		for (String string : a) {
			System.out.println(string);
		}
	}
	@Test
	public void TestDelect(){
		dao.delect("UrlData1");
	}
	@Test
	public void TestCreate(){
		dao.Create("Mytable1", "CF");
		
	}
	@Test
	public void TestNumber(){
		int n=dao.gettotalNumber(tablename,table);
    	System.out.println("Hbase中共"+n+"条数据");
	
	}
	@Test
	public void TestScan(){
		Result result = dao.get(tablename, "1");
    	System.out.println(result);
        int t=1;
    	for (KeyValue keyValue : result.raw()) {
			String t1 = new String(keyValue.getFamily());
			String t2 = new String(keyValue.getQualifier());
			String t3 = new String(keyValue.getValue());
    	    System.out.println(t3);
    	}
	}
	@Test
	public void TestGetAll(){
		List<String> a = dao.CScan("通信", table);
		System.out.println(a.size());
		//dao.delect( table, a);
	}
	
		
	

}
