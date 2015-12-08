package com.hunter.cis.bean;

import java.util.List;

import com.hunter.cis.model.Article;

public class PageBean {
	
	private List<Article> lists;
	
	private int allRow;
	private int totalPage;
	private int currentPage;
	private int pageSize;
	
	
	public List<Article> getLists() {
		return lists;
	}
	public void setLists(List<Article> lists) {
		this.lists = lists;
	}
	
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	
	
	/**
	 * 初始化分页
	 */
    public void init(){
    	this.isFirstPage=isFirstPage;
    	this.isLastPage=isLastPage;
    	this.hasNextPage=hasNextPage;
    	this.hasPreviousPage=hasPreviousPage;
    }

    /*
     * 以下是判断页的信息
     */
    public boolean isFirstPage(){
    	return (currentPage==1);
    }
    public boolean isLastPage(){
    	return currentPage==totalPage;
    }
    public boolean isHasPreviousPage(){
    	return currentPage!=1;
    }
    public boolean isHasNextPage(){
    	return currentPage!=totalPage;
    }
    /**
     * 计算总页面，静态方法
     */
    public static int countTotalPage(final int pageSize,final int allRow){
    	int totalPage=allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
    	return totalPage;
    }
    /**
     * 
     * @param pageSize
     * @param currentPage  当前第几页
     * @return 当前开始记录号
     */
    public static int countOffset(final int pageSize,final int currentPage){
    	final int offset=pageSize*(currentPage-1);
    	return offset;
    }
    public static int countCurrentPage(int page){
    	final int curPage=(page==0?1:page);
    	return curPage;
    }
    
    
}
