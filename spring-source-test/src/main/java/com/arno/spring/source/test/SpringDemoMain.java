package com.arno.spring.source.test;

import com.arno.spring.source.test.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lingquan.liu@quvideo.com
 * @Date: 2021/2/23 10:38
 * @Description:
 */
public class SpringDemoMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring-context.xml");
		applicationContext.refresh();
		User user = applicationContext.getBean("user", User.class);
		System.out.println(user);
	}
}
