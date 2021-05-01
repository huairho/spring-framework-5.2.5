package com.arno.spring.source.test;

import com.arno.spring.source.test.model.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @Author: lingquan.liu@quvideo.com
 * @Date: 2021/2/23 10:38
 * @Description: spring bean 源信息解析
 * 	1. xml 解析
 * 	2. properties 解析
 * 	3. 面向注解的 bean 解析，@Component 标注的类
 * 	4. 面向 Groovy 方式解析
 */
public class SpringBeanMateDataConfigurationMain {
	public static void main(String[] args) {
		// xml 方式解析 bean
		DefaultListableBeanFactory xmlFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(xmlFactory);
		String xmlLocation = "classpath*:/META-INF/spring-context.xml";
		xmlBeanDefinitionReader.loadBeanDefinitions(xmlLocation);
		User xmlUser = xmlFactory.getBean("user", User.class);
		System.out.println("DefaultListableBeanFactory xmlUser -> " +xmlUser);

		// properties 方式解析 bean
		DefaultListableBeanFactory propertiesBeanFactory = new DefaultListableBeanFactory();
		// PropertiesBeanDefinitionReader 拓展了 AbstractBeanDefinitionReader 类，加入 EncodedResource 的读取
		PropertiesBeanDefinitionReader propertiesDefinitionReader = new PropertiesBeanDefinitionReader(propertiesBeanFactory);
		String location = "/META-INF/user.properties";
//		propertiesDefinitionReader.loadBeanDefinitions(location); // 此方式中文乱码
		// class path 读取 resource
		Resource resource = new ClassPathResource(location);
		// 编码 resource
		EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
		propertiesDefinitionReader.loadBeanDefinitions(encodedResource);
		User propertiesUser = propertiesBeanFactory.getBean("user", User.class);
		System.out.println("PropertiesBeanDefinitionReader propertiesUser -> " + propertiesUser);

		// XmlBeanDefinitionReader 和 PropertiesBeanDefinitionReader 均实现了 BeanDefinitionReader 接口

		// 通过 AnnotatedBeanDefinitionReader 直接注册 bean class
		DefaultListableBeanFactory classFactory = new DefaultListableBeanFactory();
		// AnnotatedBeanDefinitionReader 未实现 BeanDefinitionReader 接口
		AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(classFactory);
		beanDefinitionReader.register(User.class);
		User classUser = classFactory.getBean("user", User.class);
		System.out.println("AnnotatedBeanDefinitionReader classUser ->" +classUser);

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("name", "李老四")
				.addPropertyValue("address", "BEIJING");
		AnnotationConfigApplicationContext apiContext = new AnnotationConfigApplicationContext();
		apiContext.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
		apiContext.refresh();
		User apiUser = apiContext.getBean("user", User.class);
		System.out.println("BeanDefinitionBuilder API user ->" +apiUser);
		apiContext.close();
	}
}
