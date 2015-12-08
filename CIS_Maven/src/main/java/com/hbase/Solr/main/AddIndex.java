package com.hbase.Solr.main;

import java.io.IOException;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;

public class AddIndex {
	static Table table = null;

	public static void main(String[] args) {
		// String row="http://baike.haosou.com/doc/4027470.html";
        //BuildIndexFormHbase();
	}
	public static void BuildIndexFormMysql(){
		
	}

	public static void BuildIndexFormHbase() {
		String tablename = "UrlData";

		DataDAO dao = com.hbase.Dao.DaoFactory.getInstance().getdataDAo();
		try {
			table = HbaseUtil.getHbasecon().getTable(
					TableName.valueOf(tablename));
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		/**
		 * 取出description，而不是主键,,,后面改为增加索引
		 */
		boolean b = true;

		dao.AddIndex(tablename, table);
	}
}
