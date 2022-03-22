package com.liam.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/22 16:11
 **/
// 默认加在ioc容器中组件，容器启动会调用无参构造器创建对象，在进行初始化赋值等操作
@Component
public class Boos {
	private Car car;

	public Car getCar() {
		return car;
	}

	@Autowired
	public Boos(Car car) {
		this.car = car;
		System.out.println("Boss ... 有参构造器");
	}

	// 标在方法上 spring容器创建当前对象，就会调用方法完成赋值
	// 方法使用的参数：自定义类型的值从ioc容器中获取
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boos{" +
				"car=" + car +
				'}';
	}
}
