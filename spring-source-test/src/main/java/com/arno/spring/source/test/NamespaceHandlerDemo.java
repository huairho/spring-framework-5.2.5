package com.arno.spring.source.test;

import com.arno.spring.source.test.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @desc:
 * @author: angelica
 * @date: 2021/4/4 下午2:56
 * @version:
 */
public class NamespaceHandlerDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:/META-INF/user-context.xml");

		User user = beanFactory.getBean("1", User.class);
		System.out.println(user);
	}
}
