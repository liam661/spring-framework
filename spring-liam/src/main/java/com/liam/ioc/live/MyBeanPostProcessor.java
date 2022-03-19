package com.liam.ioc.live;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 15:12
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LiveBean){
			System.out.println("run MyBeanPostProcessor postProcessBeforeInitialization method");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LiveBean){
			System.out.println("run MyBeanPostProcessor postProcessAfterInitialization method");
		}
		return bean;
	}
}
