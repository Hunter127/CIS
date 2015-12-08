package com.hbase.Test;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class Test1 {
    @org.junit.Test
	public void testSolrAdd() throws Exception{
		String url = "http://127.0.0.1:8080/solr/collection1";
		//SolrServer s=new Http
		SolrClient solr=new HttpSolrClient(url);
		
		SolrInputDocument document=new SolrInputDocument();
		
		document.addField("id", "10");
		document.addField("title", "j zhou");
		document.addField("name", "Solr是一个独立的企业级搜索应用服务器，它对外提供类似于Web-service的API接口。"
				+ "用户可以通过http请求，向搜索引擎服务器提交一定格式的XML文件"
				+ "，生成索引;也可以通过Http Get操作提出查找请求，并得到XML格式的返回结果。");
		//document.addField("price", "59.99");
		solr.add(document);
		
		solr.commit();
		solr.close();
	}
    @org.junit.Test
    public void testSolrseek() throws Exception{
    	String url="http://127.0.0.1:8080/solr/collection1";
    	SolrClient solr = new HttpSolrClient(url);
    	
    	SolrQuery sQuery=new SolrQuery();
    	sQuery.set("q", "description:救市");
    	
    	QueryResponse response=solr.query(sQuery);
    	SolrDocumentList reList=response.getResults();
    	long numFound=reList.getNumFound();
    	
    	System.out.println(numFound); 
    	//System.out.println("adsa");
    	int c=0;
    	for(SolrDocument s:reList){
    		///System.out.println(reList.size());
    		//String id=(String) s.get("id");
    		//System.out.println("ID:"+id);
    		//String name=(String)s.get("keywords");
    		//System.out.println("关键词"+name);
    		String des=(String)s.get("description");
			System.out.println(des);
			String title=s.get("title").toString();
			System.out.println(title);
    		
    	}
    }

    @org.junit.Test
    public void delectIndexs() throws Exception{
    	String url="http://127.0.0.1:8080/solr/collection1";
    	SolrClient solr = new HttpSolrClient(url);
    	
    	String query = "*:*";
		solr.deleteByQuery(query);
    	
    	solr.commit();
    }
}
