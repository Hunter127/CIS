package com.hunter.cis.bean;

import java.util.ArrayList;
import java.util.List;

import com.hunter.cis.model.Article;
/**
 * 用于存放首页的数据，
 * @author hun
 *
 */
public class FirstBean {
	private List<Article> IT=new ArrayList<Article>();
	private List<Article> electricity=new ArrayList<Article>();
	private List<Article> financial=new ArrayList<Article>();
	private List<Article> stock=new ArrayList<Article>();
	private List<Article> suiji=new ArrayList<Article>();
	private List<Article> communication =new ArrayList<Article>();
	private List<Article> furniture=new ArrayList<Article>();
	private List<Article> hardware=new ArrayList<Article>();
	public List<Article> getCommunication() {
		return communication;
	}
	public void setCommunication(List<Article> communication) {
		this.communication = communication;
	}
	public List<Article> getFurniture() {
		return furniture;
	}
	public void setFurniture(List<Article> furniture) {
		this.furniture = furniture;
	}
	public List<Article> getHardware() {
		return hardware;
	}
	public void setHardware(List<Article> hardware) {
		this.hardware = hardware;
	}
	public List<Article> getSuiji() {
		return suiji;
	}
	public void setSuiji(List<Article> suiji) {
		this.suiji = suiji;
	}
	public List<Article> getIT() {
		return IT;
	}
	public void setIT(List<Article> iT) {
		IT = iT;
	}
	public List<Article> getElectricity() {
		return electricity;
	}
	public void setElectricity(List<Article> electricity) {
		this.electricity = electricity;
	}
	public List<Article> getFinancial() {
		return financial;
	}
	public void setFinancial(List<Article> financial) {
		this.financial = financial;
	}
	public List<Article> getStock() {
		return stock;
	}
	public void setStock(List<Article> stock) {
		this.stock = stock;
	}
	

}
