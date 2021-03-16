package com.arno.spring.source.test.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lingquan.liu@quvideo.com
 * @Date: 2021/2/24 13:33
 * @Description:
 */
public class User implements Serializable {
	private static final long serialVersionUID = -4361476551632963022L;
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
