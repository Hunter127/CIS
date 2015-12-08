package com.hunter.cis.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hunter.cis.service.PageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("showAction")
@Scope("prototype")
public class ToShowAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource(name="pageService")
	private PageService ps;
	
	/**
	 *  每次都重数据库中取出一堆数据，只要数据库更新，
	 */
	public String execute() throws Exception{
		getapplication().put("firstBean",ps.FirstPage());
		return SUCCESS;
		
	}

	private Map<String,Object> getapplication(){
		return ActionContext.getContext().getApplication();
	}
}
