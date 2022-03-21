package com.liam.ioc.getBean;

import com.liam.ioc.getBean.BeanSource;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/20 15:21
 **/
public class BeanSourceFactory {
	public static BeanSource staticFactory() {
		BeanSource beanSource = new BeanSource();
		beanSource.setType("staticFactory");
		return beanSource;
	}

	public BeanSource noStaticFactory(){
		BeanSource beanSource = new BeanSource();
		beanSource.setType("noStaticFactory");
		return beanSource;
	}
}
