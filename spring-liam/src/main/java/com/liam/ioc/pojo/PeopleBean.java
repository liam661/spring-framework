package com.liam.ioc.pojo;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/13 17:46
 **/
public class PeopleBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PeopleBean() {

	}

	public PeopleBean(String name) {
		this.name = name;
	}
}
