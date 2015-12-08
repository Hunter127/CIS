package com.hunter.cis.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hunter.cis.dao.UserDao;
import com.hunter.cis.model.Admin;
import com.hunter.cis.model.User;
import com.hunter.cis.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao uDao;

	
	@Override
	public User login(User u) {
		return uDao.Check(u);
	}

	@Override
	public Admin login(Admin a) {
		// TODO Auto-generated method stub
		return uDao.check(a);
	}

	@Override
	public boolean register(User u) {
		if(uDao.Check(u.getUsername())!=null){
			return false;
		}else{
			uDao.addUser(u);
			return true;
		}
	}

	/**
	 * 管理员用户登录暂时不用
	 */
	@Override
	public boolean register(Admin a) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 用户改变密码只设置了三个值，用户名，密码，re密码
	 */
	@Override
	public boolean rePassword(User u,String password) {
		User user = uDao.Check(u);
		if(user==null){
			//用户不存在，也就是用户名或密码错误
			return false;  
		}
		user.setPassword(password);
		uDao.update(user);
		return true;
	}

}
