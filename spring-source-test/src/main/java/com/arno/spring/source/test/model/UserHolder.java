package com.arno.spring.source.test.model;

/**
 * @desc:
 * @author: Arno.KV
 * @date: 2021/3/27 下午3:38
 * @version:
 */
public class UserHolder {
	private static final long serialVersionUID = -2309285745950839337L;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"description='" + description + '\'' +
				'}';
	}
}
