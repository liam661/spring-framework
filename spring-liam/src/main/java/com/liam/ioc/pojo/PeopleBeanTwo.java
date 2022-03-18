package com.liam.ioc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 16:54
 **/
public class PeopleBeanTwo {

	@Autowired
	@Qualifier("p1")
	private PeopleBean peopleBean;

	public PeopleBean getPeopleBean() {
		return peopleBean;
	}

	public void setPeopleBean(PeopleBean peopleBean) {
		this.peopleBean = peopleBean;
	}
}
