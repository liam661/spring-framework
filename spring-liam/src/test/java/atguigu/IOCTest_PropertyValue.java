package atguigu;

import com.liam.atguigu.bean.Person;
import com.liam.atguigu.config.MainConfigOfLifeCycle;
import com.liam.atguigu.config.MainConfigOfPropertyValues;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:07
 **/
public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

	@Test
	public void test01(){
		printBeans(applicationContext);
		// 创建IOC容器
			System.out.println("容器创建完成...");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println("环境变量值： "+environment.getProperty("person.nickName"));
		applicationContext.close(); // 关闭容器
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String [] definations = applicationContext.getBeanDefinitionNames();
		for(String name : definations) {
			System.out.println(name);
		}
	}
}
