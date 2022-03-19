package com.liam.ioc.pojo;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/13 17:46
 **/
public class PeopleBean {
	private String name;

	public PeopleBean(String name) {
		this.name = name;
	}

	/*private List<String> list;

	private Map<String, String> map;*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}*/
}
