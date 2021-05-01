package com.arno.spring.source.test.xml;

import com.arno.spring.source.test.model.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @desc: user xml 解析器 {@link BeanDefinitionParser}
 * @author: angelica
 * @date: 2021/4/4 下午2:38
 * @version:
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		parseElement("id", element, builder);
		parseElement("name", element, builder);
		parseElement("address", element, builder);
		parseElement("city", element, builder);
	}

	private void parseElement(String elementName, Element element, BeanDefinitionBuilder builder) {
		String attribute = element.getAttribute(elementName);
		if (StringUtils.hasText(attribute)) {
			builder.addPropertyValue(elementName, attribute);
		}
	}
}
