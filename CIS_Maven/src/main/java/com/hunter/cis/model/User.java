package com.hunter.cis.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;
	private String tel;
	private String email;
	private Set<Company> companys=new HashSet<Company>();  //用户关注的企业
	private Industry industry;
	private Date createTime;
	private Date lastTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Company> getCompanys() {
		return companys;
	}
	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", tel=" + tel + ", email=" + email
				+ ", industry=" + industry + ", createTime=" + createTime
				+ ", lastTime=" + lastTime + "]";
	}
	

	
	
}
