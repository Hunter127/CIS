package com.hunter.cis.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hunter.cis.bean.FirstBean;
import com.hunter.cis.bean.PageBean;
import com.hunter.cis.dao.ArticleDao;
import com.hunter.cis.model.Article;
import com.hunter.cis.service.PageService;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Resource(name="articleDao")
	private ArticleDao arDao;
	@Override
	public FirstBean FirstPage() {
		FirstBean fb=new FirstBean();
		Map<String, List<Article>> map = arDao.Show();
		fb.setElectricity(map.get("电商"));
		fb.setFinancial(map.get("金融"));
		fb.setIT(map.get("IT"));
		fb.setStock(map.get("股票"));
		fb.setSuiji(map.get("随机"));
		fb.setCommunication(map.get("通信"));
		fb.setFurniture(map.get("家具"));
		fb.setHardware(map.get("硬件"));
		
		return fb;
	}

	@Override
	public PageBean getArticleByPage(int pageSize, int page, long id) {
		final String hql="select art from Article art where art.industry="+id;
		int allRow=100;
		int totalPage=PageBean.countTotalPage(pageSize, allRow);
		final int offset=PageBean.countOffset(pageSize, page);
		final int length=pageSize;
		final int currentPage=PageBean.countCurrentPage(page);
		List<Article> lists=arDao.getArticleByPage(hql, offset, length);
		
		PageBean pBean=new PageBean();
		pBean.setPageSize(pageSize);
		pBean.setCurrentPage(currentPage);
		pBean.setAllRow(allRow);
		pBean.setTotalPage(totalPage);
		pBean.setLists(lists);
		pBean.init();
		return pBean;

	}

	@Override
	public void Add(Article a) {
		arDao.Add(a);
		
	}

	@Override
	public void delectArt(int id) {
		final String hql="select art from Article art where art.industry="+id;
		arDao.DelectArticle(hql);
	}

}
