package com.hunter.cis.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.common.SolrInputDocument;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunter.cis.dao.ArticleDao;
import com.hunter.cis.model.Article;
import com.hunter.cis.util.SolrUtil;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	// 线性安全，不去使用Temple，会产生耦合
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取与当前绑定的session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Article> getArticleByPage(final String hql,final int offset, final int length) {
		Query query=getSession().createQuery(hql).setMaxResults(length).setFirstResult(offset);
		return query.list();
	}

	/**
	 * 对于批量删除，是有必要研究的，session.delect只能一次删除一个对象，要批量删除，可以用hql语句来执行
	 * 如：delect User u where u.age<30;
	 */
	@Override
	public void DelectArticle(String hql) {
		Query q = getSession().createQuery(hql);
		List<Article> ar = q.list();
		for (Article article : ar) {
			getSession().delete(article);
		}

	}

	/**
	 * 首页显示
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Article>> Show() {
		Map<String,List<Article>> listss=new HashMap<String,List<Article>>();
		
		String hql = "select art from Article art where art.industry=6";
		List<Article> lists=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("IT", (List<Article>) lists);
		
		String hql1 = "select art from Article art where art.industry=4";
		List<Article> lists1=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("电商", (List<Article>) lists1);
		
		String hql2 = "select art from Article art where art.industry=2";
		List<Article> lists2=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("金融", (List<Article>) lists2);
		
		String hql3 = "select art from Article art where art.industry=10";
		List<Article> lists3=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("股票", (List<Article>) lists3);
		
		String hql4= "select art from Article art where art.industry=1";
		List<Article> lists4=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("家具", (List<Article>) lists4);
		
		String hql5= "select art from Article art where art.industry=8";
		List<Article> lists5=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("通信", (List<Article>) lists5);
		
		String hql6= "select art from Article art where art.industry=9";
		List<Article> lists6=getSession().createQuery(hql).setMaxResults(8).list();
		listss.put("硬件", (List<Article>) lists6);
		
		  
		String sql = "select * from Article order by rand() limit ?";
		List<Article> list0=new ArrayList<Article>();
		list0 = getSession().createSQLQuery(sql).addEntity(Article.class).setInteger(0, 5).list(); 
		//System.out.println(lists.size());
		listss.put("随机", (List<Article>) list0);
		
		
		
		return listss;
	}
	
    /**
     * 增加索引
     */
	@Override
	public void BulidIndex(int count) {
		int sum = 0;
		try {
			for (int i = 0; i < count; i = i + 100) {
				String hql3 = "select art from Article art";
				Query query3 = getSession().createQuery(hql3);
				query3.setMaxResults(100);
				query3.setFirstResult(i);
				List<Article> lists1 = query3.list();

				for (Article j : lists1) {
					SolrInputDocument solrDoc = new SolrInputDocument();
					solrDoc.addField("id", j.getFromUrl());
					solrDoc.addField("keywords", j.getKeywords());
					solrDoc.addField("description", j.getContent());
					solrDoc.addField("title", j.getTitle());
					System.out.println("建立第" + sum + "索引成功");
					sum++;
					SolrUtil.getCon().add(solrDoc);
				}
				SolrUtil.getCon().commit();

			}
			SolrUtil.getCon().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public long GetAllnum() {
		String hql = "select count(*)  from Article ";
        return ((Long)  getSession().createQuery(hql).iterate().next()).intValue();
	}

	@Override
	public boolean Add(Article art) {
		getSession().save(art);
		return true;
	}

}
