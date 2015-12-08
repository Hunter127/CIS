package com.hunter.cis.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hunter.cis.model.User;
import com.hunter.cis.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户层控制层与数据操作层都应该减少逻辑操作，，逻辑放在服务层
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;
	@Resource(name="userService")
	private UserService us;
	
	 /**
	  * 登录
	  * @return
	  */
	public String login(){
		User u=us.login(user);
		if(u!=null){
			getSession().put("login_user", u);
			return SUCCESS;
		}else{
			addActionError("登录异常");
			return INPUT;
		}
	}

	/**
	 * 注册
	 * @return
	 */
	public String register(){
		if(us.register(user)){
			return SUCCESS;
		}else{
			this.addActionError("注册异常");
			return INPUT;
		}
	}
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		getSession().clear();
		return SUCCESS;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
}
