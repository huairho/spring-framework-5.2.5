package com.arno.spring.source.test.model;

import java.io.Serializable;

/**
 * @Author: lingquan.liu@quvideo.com
 * @Date: 2021/2/24 13:33
 * @Description:
 */
public class User implements Serializable {
	private static final long serialVersionUID = -4361476551632963022L;
	private Long id;
	private String name;
	private String address;
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", city=" + city +
				'}';
	}
}
