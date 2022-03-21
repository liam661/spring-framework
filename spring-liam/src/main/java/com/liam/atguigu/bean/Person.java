package com.liam.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:07
 **/

public class Person {
	// 1.基本类型
	// 2.可以写Spel：#{}
	// 3.可以写${} 可以取出配置文件中的值（在运行环境变量中的值）
	@Value("张三")
	private String name;
	@Value("#{20-2}")
	private int age;

	@Value("${person.nickName}")
	private String nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
