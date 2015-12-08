package com.hunter.cis.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hunter.cis.model.User;
import com.hunter.cis.service.PageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("articleAction")
@Scope("prototype")
public class GetArticleListAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	//当前第几页
	private int page;
	@Resource(name="pageService")
    private PageService ps;
	/**
	 * 分页实现
	 */
	public String execute() throws Exception{
		User u = (User)getSession().get("login_user");
        getapplication().put("Bean", ps.getArticleByPage(10, page, u.getIndustry().getId()));
		return SUCCESS;
	}
	
	private Map<String,Object> getapplication(){
		return ActionContext.getContext().getApplication();
	}
	private Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
}
