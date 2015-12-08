package com.hunter.cis.service;

import java.util.List;

import com.hunter.cis.bean.Message;

/**
 * 主要用于搜索
 * @author hun
 *
 */
public interface SolrService {
	/**
	 * 搜索页面显示信息,三个页面全在这里了。
	 * @param word
	 * @return
	 */
	public List<Message> GetResult(String word);

}
