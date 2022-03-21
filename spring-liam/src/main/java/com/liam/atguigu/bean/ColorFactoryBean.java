package com.liam.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 17:51
 **/
// 创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

	// 返回一个Color对象，这个对象会添加到容器中
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean... get Objects");
		return new Color();
	}


	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	// 是单例？
	// true: 这个bean是单例，在容器中保存一份
	// false :多实例，每次获取都会创建一个bean
	@Override
	public boolean isSingleton() {
		return true;
	}
}
