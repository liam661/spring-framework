package com.liam.ioc.pojo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 14:44
 **/
public class MethodReplacerApple implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("方法替换");
		return obj;
	}
}
