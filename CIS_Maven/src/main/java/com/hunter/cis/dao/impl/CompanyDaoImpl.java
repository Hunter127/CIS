package com.hunter.cis.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunter.cis.dao.CompanyDao;
import com.hunter.cis.model.Company;

@Repository(value="companyDao")
public class CompanyDaoImpl implements CompanyDao {

	//线性安全，不去使用Temple，会产生耦合
		@Autowired
		private SessionFactory sessionFactory;
		
		/**
		 * 获取与当前绑定的session 
		 */
		private Session getSession(){
			return sessionFactory.getCurrentSession();
		}
	@Override
	public void Add(Company c) {
		getSession().save(c);
	}

}
