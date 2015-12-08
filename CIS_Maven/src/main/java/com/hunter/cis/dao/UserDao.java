package com.hunter.cis.dao;

import com.hunter.cis.model.Admin;
import com.hunter.cis.model.Company;
import com.hunter.cis.model.User;

/**
 * 业务分层，Dao接口，数据访问层
 * @author hun
 *
 */
public interface UserDao {
	/**
	 * 注册，就要增加用户，在Dao层定义一个接口
	 * @param user
	 */
	public void NotUserToCompany(User user,Company c);
	public void UserToCompany(User user,Company c);
	
	public void addUser(User user);
	/**
	 * 查看用户，一般用在登录的情况下,只有到用户名与密码
	 * @param u
	 * @return
	 */
	public User Check(User u);
	/**
	 * 检测用户名是否存在
	 * @param username
	 * @return
	 */
	public User Check(String username);
	public void update(User user);
	public boolean delect(User user);
	
	public Admin check(Admin a);
	public boolean addUser(Admin admin);
}
