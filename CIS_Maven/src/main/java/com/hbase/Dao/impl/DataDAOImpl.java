package com.hbase.Dao.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.hbase.Dao.DataDAO;
import com.hbase.utils.HbaseUtil;

/**
 * 
 *
 * @author hun
 *
 */
public class DataDAOImpl implements DataDAO {

	// private static Connection con = HbaseUtil.getHbasecon(); //bad propgram
	static int count = 0;
	boolean t = false;

	@Override
	public boolean Create(String tableName, String CF) {

		try {
			Admin admin = HbaseUtil.getHbasecon().getAdmin();
			TableName tableName2 = TableName.valueOf(tableName);
			HTableDescriptor tableDescriptor = new HTableDescriptor(tableName2);
			if (admin.tableExists(tableName2)) {
				System.out.println(tableName2 + "exist，faild to create");
			} else {
				HColumnDescriptor hDescriptor = new HColumnDescriptor(CF);
				// hDescriptor.set
				hDescriptor.setMaxVersions(1);
				tableDescriptor.addFamily(hDescriptor);
				admin.createTable(tableDescriptor);
				t = true;
				System.out.println("success to create");
			}
			admin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	@Override
	public boolean delect(String tableName) {

		try {
			Admin admin = HbaseUtil.getHbasecon().getAdmin();
			TableName tableName2 = TableName.valueOf(tableName);
			if (admin.tableExists(tableName2)) {
				try {
					admin.disableTable(tableName2);
					admin.deleteTable(tableName2);
					System.out.println(tableName + "  success to delect");
					t = true;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("faild to delect");
				}
			}
			admin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * some problem is ouccur ,Table is a connection pool for table.if the table
	 * connection is not close,while data input about little data just a little
	 * problem .but the patch data input , This is a serious mistake,i take the
	 * mistake not long time. The table connection is not close,~-~ But
	 * fortunately i found connection pool size is about 300 of the Hbase table.
	 * but important is like this program is bad for patch input.single input is
	 * good. Due to patch input efficiency is low,becacuse the table conncetion
	 * to get for many time
	 * 
	 * this program is bad for patch input*****
	 */
	@Override
	public boolean Puted(String tableName, String Rowkey, String name,
			String context, Table table) {

		String CF = "info";
		try {
			// Table table =
			// HbaseUtil.getHbasecon().getTable(TableName.valueOf(tableName));
			Put p = new Put(Bytes.toBytes(Rowkey));
			p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("Name"),
					Bytes.toBytes(name));
			p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("Context"),
					Bytes.toBytes(context));
			table.put(p);
			t = true;
			System.out.println("第" + count + "数据添加成功");
			count++;
			// table.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void Puted(String tablename, Table table, String type, String url,
			String content) {
		String CF = "info";
		try {
			Put p = new Put(Bytes.toBytes(url));
			p.addColumn(Bytes.toBytes(CF), Bytes.toBytes(type),
					Bytes.toBytes(content));
			table.put(p);
			System.out.println("第" + count + "数据添加成功");
			count++;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 表名，url，Map属性，Table属性，文本String
	 */
	@Override
	public void Puted(String tablename, String tmp, Map<String, String> map,
			Table table, String string) {
		String CF = "info";
		try {
			// Table table =
			// HbaseUtil.getHbasecon().getTable(TableName.valueOf(tableName));
			Put p = new Put(Bytes.toBytes(tmp));

			if (map.get("description") != null) {
				p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("description"),
						Bytes.toBytes(map.get("description")));
			}
			if (map.get(tmp) != null) {
				p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("url"),
						Bytes.toBytes(tmp));
			}
			if (map.get("title") != null) {
				p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("title"),
						Bytes.toBytes(map.get("title")));
			}
			if (map.get("keywords") != null) {
				p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("keywords"),
						Bytes.toBytes(map.get("keywords")));
			}
			p.addColumn(Bytes.toBytes(CF), Bytes.toBytes("context"),
					Bytes.toBytes(string));
			table.put(p);
			t = true;
			System.out.println("第" + count + "数据添加成功");
			count++;
			// table.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return t;

	}

	@Override
	public int gettotalNumber(String tableName, Table table) {
		StringBuffer sb = new StringBuffer();
		int n = 0;
		String string = null;
		try {

			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s);

			for (Result r : ss) {
				n += r.size();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;

	}

	@Override
	public Result get(String tableName, String row) {
		Result result = null;
		try {
			Table table = HbaseUtil.getHbasecon().getTable(
					TableName.valueOf(tableName));

			Get get = new Get(Bytes.toBytes(row));
			get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("p"));
			get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("url"));
			result = table.get(get);
			// System.out.println(result);
			// table.close();
			// / System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<String> ListALLTable() {
		Admin admin;
		List<String> a = new ArrayList<String>();
		try {
			admin = HbaseUtil.getHbasecon().getAdmin();
			HTableDescriptor[] tableDescriptor = admin.listTables();
			for (HTableDescriptor h : tableDescriptor) {
				a.add(h.getNameAsString());
			}
			admin.close();
			HbaseUtil.closeHbase();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public String AddIndex(String tablename, Table table) {

		String string = null;
		// SolrClient solr = ConneUtil.getSolrcon();
		String url = "http://127.0.0.1:8080/solr/collection1";
		SolrClient solr = new HttpSolrClient(url);
		try {

			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s);
			int n = 0;

			for (Result r : ss) {
				SolrInputDocument solrDoc = new SolrInputDocument();
				solrDoc.addField("id", new String(r.getRow()));
				for (KeyValue kv : r.raw()) {
					String fieldName = new String(kv.getQualifier());
					String fieldValue = new String(kv.getValue());
					if ("keywords".equals(fieldName)) {
						solrDoc.addField("keywords", fieldValue);
						System.out.println("索引第" + n + "条数据");
					}
					if ("description".equals(fieldName)) {
						solrDoc.addField("description", fieldValue);
					}
					if ("title".equals(fieldName)) {
						solrDoc.addField("title", fieldValue);
					}

					solr.add(solrDoc);
				}
				n++;
				solr.commit();
			}
			solr.close();

		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}
		return string;

	}

	@Override
	public List<Map<String, String>> CUSScan(String Name, Table table,
			String ida) {
		StringBuffer sb = new StringBuffer();
		int n = 0;
		String string = null;
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();

		try {

			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s.addColumn(
					Bytes.toBytes("info"), Bytes.toBytes(Name)));
			Document doc = null;
			for (Result r : ss) {
				Map<String, String> maps = new HashMap<String, String>();
				// r.getRow();
				maps.put("url", new String(r.getRow())); // url
				for (KeyValue kv : r.raw()) {

					String fieldName = new String(kv.getQualifier());
					String fieldValue = new String(kv.getValue());
					if (Name.equals(fieldName)) {
						doc = Jsoup.parse(fieldValue);
						Element content = doc.getElementById(ida);
						// String title = doc.title();
						Elements h1 = doc.getElementsByTag("h1");

						System.out.println("1");
						maps.put("title", h1.text()); // 标题
						Element head = doc.head();
						Elements metas = head.select("meta");
						for (Element meta : metas) {

							if ("description".equalsIgnoreCase(meta
									.attr("name"))) {

								maps.put("description", meta.attr("content"));// 关键词
							}
						}

						if (content != null) {
							// System.out.println( content.html());
							maps.put("context", content.html()); // 内容
						}
					}
				}
				ls.add(maps);

			}
			return ls;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean IsExist(String ta) {
		try {
			Admin admin = HbaseUtil.getHbasecon().getAdmin();
			TableName tableName2 = TableName.valueOf(ta);
			if (admin.tableExists(tableName2)) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 返回某一个列，为了删除这个列,家电
	 */
	@Override
	public List<String> CScan(String Name, Table table) {
		List<String> ls = new ArrayList<String>();

		try {

			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s.addColumn(
					Bytes.toBytes("info"), Bytes.toBytes(Name)));

			for (Result r : ss) {
				System.out.println(new String(r.getRow()));
				String fieldValue = new String(r.getValue(
						Bytes.toBytes("info"), Bytes.toBytes(Name)));

				if (fieldValue != null) {
					ls.add(new String(r.getRow()));
					// System.out.println(new String(r.getRow()));
					// System.out.println("1");
				}

			}
			return ls;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean delect(Table table, List<String> a) {
		List<Delete> s = new ArrayList<Delete>();

		try {
			for (String string : a) {
				Delete delete = new Delete(Bytes.toBytes(string));
				s.add(delete);
			}
			table.delete(s);
			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}

}
