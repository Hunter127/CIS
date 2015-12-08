package com.hunter.cis.test;

import java.util.HashSet;
import java.util.Set;

public class test1 {
	public static void main(String[] args) {
		A a1=new A("1","2");
		A a2=new A("1","2");
		Set<A> set=new HashSet<A>();
		set.add(a1);
		set.add(a2);
		
		System.out.println(set.size());
		System.out.println(a1==a2);
	}

}
