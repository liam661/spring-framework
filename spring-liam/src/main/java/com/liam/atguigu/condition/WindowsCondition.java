package com.liam.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 16:45
 **/
public class WindowsCondition implements Condition {
	/**
	 *
	 * @param context the condition context 判读条件能使用的上下文环境
	 * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
	 * or {@link org.springframework.core.type.MethodMetadata method} being checked
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//1 获取当前bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2 获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3 获取当前环境信息
		Environment environment = context.getEnvironment();
		//4 获取bean定义的注册类
		BeanDefinitionRegistry contextRegistry = context.getRegistry();
		String property = environment.getProperty("os.name");
		boolean ifPerson = contextRegistry.containsBeanDefinition("person");
		if(property.contains("Windows")) {
			return true;
		}
		return false;
	}
}
