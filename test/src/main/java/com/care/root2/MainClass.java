package com.care.root2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext
			ctx = new GenericXmlApplicationContext(path);
		STBean stb = ctx.getBean("stb",STBean.class);
		
//		stb.setName("김개똥");
//		stb.setAge(300);
		stb.namePrint();
		stb.agePrint();
	}

}
