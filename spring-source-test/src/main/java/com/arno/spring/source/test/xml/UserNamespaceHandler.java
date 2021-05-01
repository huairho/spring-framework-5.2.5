package com.arno.spring.source.test.xml;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @desc: users.xsd {@link NamespaceHandler} 实例
 * @author: angelica
 * @date: 2021/4/4 下午2:36
 * @version:
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
