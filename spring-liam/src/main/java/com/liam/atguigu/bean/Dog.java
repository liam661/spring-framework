package com.liam.atguigu.bean;

import org.springframework.stereotype.Component;


/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:28
 **/
@Component
public class Dog {

	public Dog() {
		System.out.println("dog constructor");
	}

	public void init() {
		System.out.println("Dog...@Predestroy...");
	}

	public void destory(){
		System.out.println("Dog...@Predestroy...");
	}
}
