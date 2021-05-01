package com.arno.spring.source.test;

import com.arno.spring.source.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Optional;

/**
 * @author Angelica.arno
 * @since 1.0.0
 */
public class AutowiredDemo {

	@Autowired
	private User user;

//	@Autowired
//	private Map<String, User> userMap;
//
//	@Autowired
//	private Optional<User> userOption;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AutowiredDemo.class);

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
		reader.loadBeanDefinitions("/META-INF/spring-context.xml");

		applicationContext.refresh();

		AutowiredDemo demo = applicationContext.getBean(AutowiredDemo.class);
		System.out.println(demo.user);
//		System.out.println(demo.userMap);
//		System.out.println(demo.userOption);

		applicationContext.close();
	}
}
