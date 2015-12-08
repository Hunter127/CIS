package com.hunter.cis.dao;

import com.hunter.cis.model.Company;


/**
 * 定义一些企业的简单操作，预处理,,要先加入企业再进行用户关注服务
 * @author hun
 *
 */
public interface CompanyDao {
	public void Add(Company c);
}
