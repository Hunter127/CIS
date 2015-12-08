package com.hbase.Test;

import java.util.ArrayList;

import com.hbase.utils.InitUrl;

public class Test3 {

	public static void main(String[] args) {
		InitUrl init=new InitUrl();
		ArrayList<String> list = init.getInitUrl();
		for( int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
	}

}
