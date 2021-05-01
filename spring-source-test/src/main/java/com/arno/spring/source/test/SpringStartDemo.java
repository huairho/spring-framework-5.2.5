package com.arno.spring.source.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc:
 * @author: angelica
 * @date: 2021/4/3 下午4:32
 * @version:
 */
public class SpringStartDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringStartDemo.class);
		applicationContext.refresh();
		applicationContext.start();
	}
}
