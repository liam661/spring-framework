package com.liam.atguigu.config;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:03
 **/

import com.liam.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Callable;

/**
 * bean生命周期
 * 		bean --- 初始化--- 销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法；容器在bean进行找当前生命周期的时候
 * 来调用我们自定义初始化和销毁方法
 *
 * 构造（对象创建）
 * 	单实例：在容器启动的时候创建
 * 	多实例：在每次获取的时候创建
 * 	postProcessBeforeInitialization
 * 	初始化：
 * 		在对象创建完成，并赋值好，调用初始化方法
 * 	postProcessAfterInitialization
 * 	销毁：
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个bean：容器不会关闭
 *
 *   遍历得到容器中所有的BeanPostProcessor,挨个执行，一旦返回null，跳出for不会执行后面的
 *    BeanPostProcessor 原理：
 *   populateBean(beanName,mbd,instanceWrapper) // 给bean属性赋值
 *   initializeBean
 *   {
 *     applyBeanPostProcessorsBeforeInitialization()
 *     invokeInitMethods()
 *     applyBeanPostProcessorsAfterInitialization()
 *   }
 *
 *  1） 指定初始化和销毁方法
 *      通过@Bean指定的init-method和destroy-method
 *  2）通过Bean实现InitializingBean，DisposableBean
 *  3) 可以使用JSR250 jdk11 已废弃
 * 		@PostConstruct，在bean创建完成并且属性赋值完成，来执行初始化方法
 * 		@PreDestroy 在容器销毁bean之前通知我们的清理工作
 *	4) BeanPostProcessor bean的后置处理器
 *		postProcessBeforeInitialization	在初始化之前
 *		postProcessAfterInitialization	在初始化之后
 *
 *  Spring底层对BeanPostProcessor使用
 *  	bean赋值，注入其他组件，@Autowired 生命周期注解功能，@Async，异步注解
 */
@ComponentScan("com.liam.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Car car(){
		return new Car();
	}
}
