package com.hbase.utils;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;

/**
 * 连接是重量级的
 * @author hun
 *
 */
public final class HbaseUtil {
	private static String quorum="hbase.zookeeper.quorum";
	private static String IP="192.168.1.2,192.168.1.116,192.168.1.117";
	private static Connection connection;
	public static Connection getHbasecon(){
		try {
			Configuration conf = HBaseConfiguration.create();
			conf.addResource("hbase-site.xml");
			conf.addResource("core-site.xml");
			conf.set(quorum, IP);
			conf.set("hbase.zookeeper.property.clientPort", "2181");
			
			connection = ConnectionFactory.createConnection(conf); 
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
		
	}
	public static void  closeHbase() {
		try {
			 connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}


