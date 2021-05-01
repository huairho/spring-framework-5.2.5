package com.arno.spring.source.test;

import com.arno.spring.source.test.model.User;
import com.arno.spring.source.test.model.UserHolder;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @desc: Bean 生命周期示例引导类
 * @author: Arno.KV
 * @date: 2021/3/27 下午3:40
 * @version:
 */
public class SpringBeanLifecycleDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// bean 源信息解析
		xmlMateData(beanFactory);
		propertiesMeteData(beanFactory);
		beanDefinitionBuilder(beanFactory);
		annotatedReader(beanFactory);
		User xmlUser = beanFactory.getBean("xmlUser", User.class);
		System.out.println("xmlUser：" + xmlUser);

		User propertiesUser = beanFactory.getBean("user", User.class);
		System.out.println("propertiesUser：" + propertiesUser);

		User builderUser = beanFactory.getBean("builderUser", User.class);
		System.out.println("builderUser：" + builderUser);

		UserHolder annotatedUserHolder = beanFactory.getBean("userHolder", UserHolder.class);
		System.out.println("annotatedUserHolder：" + annotatedUserHolder);

		UserHolder xmlUserHolder = beanFactory.getBean("xmlUserHolder", UserHolder.class);
		System.out.println("xmlUserHolder：" + xmlUserHolder);
	}

	/**
	 * xml 配置
	 * @param beanFactory
	 */
	private static void xmlMateData(DefaultListableBeanFactory beanFactory) {
		String location = "classpath:/META-INF/spring-context.xml";
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(location);
	}

	/**
	 * properties 配置
	 * @param beanFactory
	 */
	private static void propertiesMeteData(DefaultListableBeanFactory beanFactory) {
		String location = "/META-INF/user.properties";
		Resource resource = new ClassPathResource(location);
		EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(encodedResource);
	}

	/**
	 * BeanDefinitionBuilder API
	 * @param beanFactory
	 */
	private static void beanDefinitionBuilder(DefaultListableBeanFactory beanFactory) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("name", "小李")
				.addPropertyValue("address", "HANGZHOU");
		beanFactory.registerBeanDefinition("builderUser", beanDefinitionBuilder.getBeanDefinition());
	}

	/**
	 * Component register 方式
	 * @param beanFactory
	 */
	private static void annotatedReader(DefaultListableBeanFactory beanFactory) {
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
		reader.register(UserHolder.class);
	}

}
