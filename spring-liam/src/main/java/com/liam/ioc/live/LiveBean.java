package com.liam.ioc.live;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 14:52
 **/
public class LiveBean implements BeanNameAware, BeanFactoryAware , ApplicationContextAware,
		InitializingBean, DisposableBean, BeanClassLoaderAware, EnvironmentAware,
		EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware
{

	private String address;

	public LiveBean(){
		System.out.println("init LiveBean");
	}

	public void myPostConstruct() {
		System.out.println("run myPostConstruct method");
	}

	public void myPreDestroy(){
		System.out.println("run myPreDestroy method");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("run setMessageSource ");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("run setApplicationEventPublisher ");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("run setResourceLoader ");
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("run setEmbeddedValueResolver ");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("run setEnvironment ");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("run setBeanClassLoader");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("run destroy method.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("run afterPropertiesSet Method");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}

	@Override
	public void setBeanName(String name) {
		System.out.println("run setName method.");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("run setBeanFactory method.");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
