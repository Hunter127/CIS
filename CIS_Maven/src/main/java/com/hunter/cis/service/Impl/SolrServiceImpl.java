package com.hunter.cis.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import com.hunter.cis.bean.Message;
import com.hunter.cis.service.SolrService;
import com.hunter.cis.util.SolrUtil;

@Service("solrService")
public class SolrServiceImpl implements SolrService {
	private static SolrClient solr=SolrUtil.getCon();
	SolrQuery sQuery=new SolrQuery();

	@Override
	public List<Message> GetResult(String word) {
		List<Message> messages=new ArrayList<Message>();
		try{
			sQuery.setQuery(word);
			QueryResponse response=solr.query(sQuery);
			SolrDocumentList reList=response.getResults();
			
			for(SolrDocument s:reList){
				String id=(String)s.get("id");
				String des=(String)s.get("description");
				String s1=s.get("title").toString();
				messages.add(new Message(id,des,s1));
			}
			return  messages;
		}catch(SolrServerException|IOException e){
			e.printStackTrace();
			return null;
		}
		
	}

}
