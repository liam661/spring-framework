package com.liam.atguigu.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:04
 **/
//名字默认是类名首字母小写
@Repository
public class BookDao {
	private String lable = "1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "BookDao{" +
				"lable='" + lable + '\'' +
				'}';
	}
}
