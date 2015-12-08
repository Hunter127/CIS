package com.hbase.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {
	@Test
	public void TestJiexi() throws Exception{
		Document doc = null;
		
			doc = Jsoup.parse("");
			
					 Element content = doc.getElementById("maintab");
					 
					 if(content!=null){
						 System.out.println( content.html()); 
					 }
					
					 
		//Document doc = Jsoup.parse(t);
		/* String title=doc.title();
		 Elements h1 = doc.getElementsByTag("h1");
			System.out.println(h1.text());
			Elements p1 = doc.getElementsByTag("p");
			StringBuffer sb=new StringBuffer();
			for(Element s:p1){
				//尽可能提取到文本内容
				if(s.text().length()>10){
				sb.append(s.text()+"\n\r");
			}
			}*/
			
		
	}

}
