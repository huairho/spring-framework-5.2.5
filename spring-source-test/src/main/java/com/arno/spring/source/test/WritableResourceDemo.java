package com.arno.spring.source.test;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * <code>FileSystemResource</code> 和 <code>EncodedResource</code> 示例代码
 *
 * @author Angelica.arno
 * @since 1.0.0
 */
public class WritableResourceDemo {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));

		String currentJavaPath = System.getProperty("user.dir") + "/spring-source-test/src/main/java/com/arno/spring/source/test/WritableResourceDemo.java";

		File currentJavaFile = new File(currentJavaPath);
		FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFile);

		EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");

		Reader reader = encodedResource.getReader();

		System.out.println(IOUtils.toString(reader));
	}
}
