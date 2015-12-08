package com.hbase.Test;

import java.io.IOException;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ConnectionUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.solr.client.solrj.SolrClient;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;


public class Test2 {
	
	    static Table table = null;
	
    	String tablename="UrlData";
    	
    	private  DataDAO dao=com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
 
		    //  table = HbaseUtil.getHbasecon().getTable(TableName.valueOf(tablename));
		
   // 	dao.delect("UrlData");
    	//String string = dao.scan(tablename, table);    //对keyword进行scan
    	//DataUtil.saveKey(string);
    	
    	//Result result = dao.get(tablename, row);
    	//System.out.println(result);
    /*	int t=1;
    	for (KeyValue keyValue : result.raw()) {
			String t1 = new String(keyValue.getFamily());
			String t2 = new String(keyValue.getQualifier());
			String t3 = new String(keyValue.getValue());
    	    System.out.println(t3);
    	    DataUtil.save(t3, t);
    	   // System.out.println("11");
    	    t++;
    	}*/
    	//dao.scan(tablename, table);
    	/**
    	 * 取出description，而不是主键,,,后面改为增加索引
    	 */
    	//boolean b=true;
    	
    	//int n=dao.gettotalNumber(tablename,table);
    	//System.out.println("Hbase中共"+n+"条数据");
	
	
}
