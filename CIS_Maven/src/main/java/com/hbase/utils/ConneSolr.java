package com.hbase.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public final class ConneSolr {
	private static SolrClient solr;
	private static String url="http://127.0.0.1:8080/solr/collection1";
	
	public static SolrClient getSolrcon(){
		try {
			solr=new HttpSolrClient(url);
			System.out.println("连接成功");
			return solr;
			//
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
		
	}
	public static void  closeSolr() {
		try {
			 solr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
