package com.liam.atguigu.condition;

import com.liam.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 17:36
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 *
	 * @param importingClassMetadata annotation metadata of the importing class
	 * 当前类的注册信息
	 * @param registry current bean definition registry
	 *                 BeanDefination注册类
	 *                 把所有需要添加到容器中bean
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.liam.atguigu.bean.Blue");
		boolean definition1 = registry.containsBeanDefinition("com.liam.atguigu.bean.Red");
		if(definition && definition1){
			// 指定bean定义信息。（bean类型 scope 等）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			// 注册一个bean，指定一个bean名
			registry.registerBeanDefinition("rainBow",beanDefinition);
		}
	}
}
