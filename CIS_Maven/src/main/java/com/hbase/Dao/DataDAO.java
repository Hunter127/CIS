package com.hbase.Dao;

import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;



/**
 * hbase的操作接口
 * @author hun
 *
 */
public interface DataDAO {
	public boolean Create(String tableName,String CF);
	public boolean delect(String tableName);
	public boolean delect(Table table,List<String> a);
	//public boolean Puted(String tableName,String Rowkey,String value1,String value2);
    public int gettotalNumber(String tableName,Table table);
    public Result get(String tableName,String row);
    public boolean IsExist(String ta);
    public List<String> ListALLTable();
	boolean Puted(String tableName, String Rowkey, String name, String context,
			Table table);
	public void Puted(String tablename, String tmp, Map<String, String> map,
			Table table,String string);
	public String AddIndex(String tablename, Table table);
	public void Puted(String tablename,Table table,String CF,String url,String content);
	public List<Map<String,String>> CUSScan(String tableName,Table table,String id);
	public List<String> CScan(String tableName,Table table);
	
}
