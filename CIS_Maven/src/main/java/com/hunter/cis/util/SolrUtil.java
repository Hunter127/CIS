package com.hunter.cis.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public final class SolrUtil {
	private static String url = "http://127.0.0.1:8080/solr/collection1";
	private static SolrClient solr;

	public static SolrClient getCon(){
		try{
			solr=new HttpSolrClient(url);
			return solr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

}
