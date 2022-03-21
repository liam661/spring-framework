package com.liam.atguigu.bean;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:05
 **/
public class Car {
	public Car(){
		System.out.println("a car constructor");
	}

	public void init(){
		System.out.println("car ... init...");
	}

	public void destroy(){
		System.out.println("car ... destroy...");
	}

}
