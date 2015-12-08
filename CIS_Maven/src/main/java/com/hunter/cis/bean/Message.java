package com.hunter.cis.bean;

/**
 * 用于搜索的显示模型bean
 * @author hun
 *
 */
public class Message {
	private String id;
    private String description;
    private String title;
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Message(){}
    
    public Message(String id,String description,String a){
    	this.description=description;
    	this.id=id;
    	this.title=a;
    }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};
    
}
