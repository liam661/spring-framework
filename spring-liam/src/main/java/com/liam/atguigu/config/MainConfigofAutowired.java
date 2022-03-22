package com.liam.atguigu.config;

import com.liam.atguigu.bean.Car;
import com.liam.atguigu.bean.Color;
import com.liam.atguigu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/22 14:58
 **/

/**
 * 自动装配：
 * 	spring利用依赖注入
 * 	1.AutoWired 自动注入
 * 	1) 默认优先按照类型去容器中找对应的组件，找到就赋值
 * 	2) 如果找到多个相同类型的组件，再讲属性名称作为组件的id去容器查找，按照名字装配
 * 	3) Qualifier 使用
 * 	4) 自动装配默认一定要将属性赋值好，没有就会报错
 * 	5) Primary 让spring自动装配，默认首选的bean
 * 		也可以继续使用@Qualifier指定需要装配的bean的名字
 * 	bookService {
 * 		@Autowored
 *   	BookDao bookDao
 *    }
 * 	2. spring支持@Resource Inject【java规范】
 * 		@Resource: 可以和AutoWired一样实现自动装配功能：默认是
 * 		按照组件名称进行装配的，没有能支持@Primary功能，没有支持
 * 		Autowired(required=false)
 * 		@Inject: 需要导入javax.inject包,没有require=false功能
 *  3.  @Autowired:构造器，参数，属性，都是从容器中获取
 *  	1)方法位置:@Bean+方法参数，参数从容器中获取，默认不写@Autowired都能自动装配
 *  	2) 标在构造器，如果组件只有一个有参构造
 *  	3) 方法在参数位置
 *  4. 自定义组件想要使用spring容器底层的一些组件ApplicationContext，BeanFactory，xxx
 *  	自定义组件实现XXXAware，在创建对象的时候，会调用接口规定的方法注入相关的组件：Aware
 *  	把Spring底层一些组件注入到自定义bean中
 *  	XXXAware：功能使用：XXXXProcessor
 *  		ApplicationContextAware ==》ApplicationContextAwareProcessor
 *
 */
@Configuration
@ComponentScan({"com.liam.atguigu.service",
		"com.liam.atguigu.dao",
		"com.liam.atguigu.controller","com.liam.atguigu.bean"
})
public class MainConfigofAutowired {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}

	//
	@Bean
	public Color color(Car car){
		Color color = new Color();
		color.setCar(car);
		return color;
	}
}
