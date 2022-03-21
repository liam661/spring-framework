package com.liam.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:18
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {

	public Cat() {
		System.out.println("cat construct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("cat .. afterPropertiesSet...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("cat .. destroy...");
	}
}
