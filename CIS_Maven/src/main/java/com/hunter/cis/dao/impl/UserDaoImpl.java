package com.hunter.cis.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunter.cis.dao.UserDao;
import com.hunter.cis.model.Admin;
import com.hunter.cis.model.Company;
import com.hunter.cis.model.User;

/**
 *  底层数据库操作应该减少逻辑。
 * @author hun
 *
 */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao {

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
	public void NotUserToCompany(User user, Company c) {
		getSession().save(user.getCompanys().remove(c));
	}

	/**
	 * 用户关注企业
	 * @param user
	 * @param c
	 */
	@Override
	public void UserToCompany(User user, Company c) {
		getSession().save(user.getCompanys().add(c));
	}

	@Override
	public void addUser(User u) {
		getSession().save(u);

	}

	/**
	 * 查看用户，一般用在登录的情况下
	 * @param u
	 * @return
	 */
	@Override
	public User Check(User u) {
		String hql="SELECT u FROM User u WHERE u.username=? AND u.password=?";
		Query query=getSession().createQuery(hql).setString(0, u.getUsername()).setString(1, u.getPassword());
		return (User)query.uniqueResult();
	}

	@Override
	public void update(User user) {
		getSession().update(user);

	}

	@Override
	public boolean delect(User user) {
		getSession().delete(user);
		return true;
	}

	@Override
	public Admin check(Admin a) {
		String hql="SELECT u FROM Admin u WHERE u.username=? AND u.password=?";
		Query query=getSession().createQuery(hql).setString(0, a.getUsername()).setString(1, a.getPassword());
		return (Admin)query.uniqueResult();
	}

	@Override
	public boolean addUser(Admin admin) {
		getSession().save(admin);
		return true;
	}


	@Override
	public User Check(String username) {
		String hql="SELECT u FROM User u WHERE u.username=?";
		Query query=getSession().createQuery(hql).setString(0, username);
		return (User)query.uniqueResult();
	}

}
