package com.hunter.cis.dao;

import java.util.List;
import java.util.Map;

import com.hunter.cis.model.Article;


public interface ArticleDao {
	/**
	 * 核心翻页
	 * @param hql
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<Article> getArticleByPage(final String hql,final int offset,final int length);
   /**
    * 删除数据库内的文章，一般业务用不到	
    */
   public void DelectArticle(String hql);
   /**
    * 首页的显示
    * @return
    */
   public Map<String,List<Article>> Show();
   /**
    * 构建索引
    */
   public void BulidIndex(int count);
   /**
    * 获取文章总数
    * @return
    */
   public long GetAllnum();
   
   public boolean Add(Article art);
}
