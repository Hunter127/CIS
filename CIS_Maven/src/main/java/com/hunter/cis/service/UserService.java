package com.hunter.cis.service;

import com.hunter.cis.model.Admin;
import com.hunter.cis.model.User;

/**
 * 定义所有用户服务
 * @author hun
 *
 */
public interface UserService {
	/**
	 * 登录要用户名与密码
	 * @param u
	 * @return
	 */
	public User login(User u);
	public Admin login(Admin a);
	public boolean register(User u);
	public boolean register(Admin a);
	/**
	 * 重设密码，要用户名与密码，与re密码
	 * @param u
	 * @param password
	 * @return
	 */
	public boolean rePassword(User u,String password);

}
