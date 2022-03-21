package com.liam.atguigu.config;

import com.liam.atguigu.bean.Color;
import com.liam.atguigu.bean.ColorFactoryBean;
import com.liam.atguigu.bean.MyImportSelector;
import com.liam.atguigu.bean.Person;
import com.liam.atguigu.condition.LinuxCondition;
import com.liam.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.liam.atguigu.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 16:03
 **/
// 类中组件统一设置：满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional(WindowsCondition.class)
@Configuration
@Import({Color.class, MyImportSelector.class,  MyImportBeanDefinitionRegistrar.class})
// 快速导入组件，id默认值全包类名
public class MainConfig2 {
	// 默认单实例
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * PROTOTYPE 多实例的:ioc容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会
	 * 调用方法创建对象
	 * SINGLETON 单实例的（默认），ioc容器启动会调用方法创建对象放到ioc容器中
	 * 以后每次获取就是直接从容器（map，get）中拿
	 * request 同一次请求创建一个实例
	 * session：同一个session创建一个实例
	 *
	 * 懒加载：
	 * 	单实例bean 默认在容器启动的时候创建对象
	 * 	懒加载：容器启动不创建对象，第一次使用（获取）bean 创建对象，并初始化
	 */
	//@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器添加Person");
		return new Person("zhangsan",18);
	}
	/**
	 * @Condtaional :按照一定的条件进行判读，满足条件给容器中注册bean
	 * 如果Windows系统给容器中注册bill
	 * 如果是Linus系统给容器注册linus
	 */
	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gate", 62);
	}

	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus",48);
	}

	/**
	 * 给容器中注册组件的方式：
	 * 1.包扫描+组件标注注解（@controller、@Service、@Component、）局限自己写的类
	 * 2.@Bean 导入的第三方里面的组件
	 * 3.@Import 快速给容器中导入一个组件
	 *   1) @Import(要导入容器的组件)；容器中就会自动注册这个组件，id是
	 *   默认的全类名
	 *   2）ImportSelector: 接口返回需要导入的组件的全类名
	 *   3) ImportBeanDefinitionRegistrar:收到注册bean到容器中
	 * 4. 使用spring提供的FactoryBean（工厂bean）
	 * 	 1) 默认获取到的是工厂bean调用getObject创建的对象
	 * 	 2） 要获取工厂bean本身，需要给id前面加一个& &colorFactoryBean
	 *
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
