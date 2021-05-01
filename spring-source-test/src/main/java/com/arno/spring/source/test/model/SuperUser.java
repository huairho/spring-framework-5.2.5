package com.arno.spring.source.test.model;

/**
 * @desc:
 * @author: Arno.KV
 * @date: 2021/3/27 下午3:37
 * @version:
 */
public class SuperUser extends User {
	private static final long serialVersionUID = 187613003678628503L;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"age=" + age +
				"} " + super.toString();
	}
}
