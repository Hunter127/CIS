package com.hunter.cis.service;

import com.hunter.cis.bean.FirstBean;
import com.hunter.cis.bean.PageBean;
import com.hunter.cis.model.Article;

/**
 * 一些页面显示服务，与之并行的是SolrService，
 * @author hun
 *
 */
public interface PageService {
	/**
	 * 首页显示
	 * @return
	 */
	public FirstBean FirstPage();
	/**
	 * 用户登录后自动的主页显示，包括分页的实现
	 * @param pageSize
	 * @param page
	 * @param id
	 * @return
	 */
	public PageBean getArticleByPage(int pageSize,int page,long id);
	
	public void Add(Article a);
	
	public void delectArt(int hql);

}
