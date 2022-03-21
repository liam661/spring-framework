package atguigu;

import com.liam.atguigu.MainConfig;
import com.liam.atguigu.bean.Blue;
import com.liam.atguigu.bean.Person;
import com.liam.atguigu.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:02
 **/
public class IOCTest {
	AnnotationConfigApplicationContext applicationContext =
			new AnnotationConfigApplicationContext(MainConfig2.class);
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);
		String [] definations = applicationContext.getBeanDefinitionNames();
		for(String name : definations){
			System.out.println(name);
		}
	}

	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig2.class);
//		String [] definations = applicationContext.getBeanDefinitionNames();
//		for(String name : definations){
//			System.out.println(name);
//		}
		System.out.println("IOC容器创建完成");
		Object bean1 = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean1 == bean2);
	}

	@Test
	public void test03(){
		String [] namesForType = applicationContext.getBeanNamesForType(Person.class);
		// 获取系统信息
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println(environment.getProperty("os.name"));
		for(String name : namesForType){
			System.out.println(name);
		}
		Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
		System.out.println(personMap);
	}

	@Test
	public void testImport(){
		printBeans(applicationContext);
		Blue blue = applicationContext.getBean(Blue.class);
		System.out.println(blue);
		// 工厂bean获取的是调用getObject创建的对象
		Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
		Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean类型："+colorFactoryBean.getClass());
		System.out.println(colorFactoryBean == colorFactoryBean2);
		Object colorFactoryBean4 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean类型："+colorFactoryBean4.getClass());
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String [] definations = applicationContext.getBeanDefinitionNames();
		for(String name : definations){
			System.out.println(name);
		}
	}
}
