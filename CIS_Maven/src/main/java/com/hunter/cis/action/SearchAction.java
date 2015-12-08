package com.hunter.cis.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hunter.cis.service.SolrService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("searchAction")
@Scope("prototype")
public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource(name="solrService")
	private SolrService ss;
	private String name;
	
	public String execute() throws Exception{
		if("".equals(name)){
			return ERROR;
		}
		StringBuilder word=new StringBuilder();
		word.append("description:").append(name);
		getSession().put("result", ss.GetResult(word.toString()));
	
		return SUCCESS;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
}
