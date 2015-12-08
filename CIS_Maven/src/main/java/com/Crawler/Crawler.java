package com.Crawler;


public class Crawler {

	public static void main(String[] args) {
		int crawDepth = 5;
		int threadCount = 8;                        //线程数不应太高
		
		final Spider wc = new Spider();
		wc.addUrl("http://furniture.liwai.com/", 1);//家具
		//wc.addUrl("http://www.xnynews.com/", 1);    //家电
		String name="家具";
		//wc.addUrl("http://www.jia360.com/", 1);             //家具
		//wc.addUrl("http://news.jc001.cn", 1);
		//wc.addUrl("http://www.csdn.net/", 1);               //IT
		//wc.addUrl("http://www.c114.net/", 1);               //通信
		//wc.addUrl("http://www.ebrun.com/", 1);               //电商
		//wc.addUrl("http://www.cnbeta.com/", 1);               //硬件
		//wc.addUrl("http://stock.cngold.org/news/", 1);               //股票
		//wc.addUrl("http://www.jrj.com.cn/", 1);               //金融
    	long start = System.currentTimeMillis();
		System.out.println("The Crawler satrt.........................................");
		wc.begin(crawDepth,threadCount,start,name);

		while (true) {
			if (wc.notCrawlurlSet.isEmpty() && Thread.activeCount() == 1
					|| wc.count == threadCount) {
				long end = System.currentTimeMillis();
				System.out.println("Total to Crawler" + wc.allurlSet.size() + "page");
				System.out.println("Total use" + (end - start) / 1000 + "s");
				System.exit(1);
				// break;
			}

		}
	}

	
}
