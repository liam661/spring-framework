package com.liam.ioc.getBean;

import com.liam.ioc.getBean.BeanSource;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/20 15:25
 **/
public class BeanSourceFactoryBean implements FactoryBean<BeanSource> {

	@Override
	public BeanSource getObject() throws Exception {
		BeanSource beanSource = new BeanSource();
		beanSource.setType("from factory bean");
		return beanSource;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Class<?> getObjectType() {
		return BeanSource.class;
	}
}
