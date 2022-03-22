package atguigu;

import com.liam.atguigu.bean.Boos;
import com.liam.atguigu.bean.Car;
import com.liam.atguigu.bean.Color;
import com.liam.atguigu.bean.Person;
import com.liam.atguigu.config.MainConfigOfPropertyValues;
import com.liam.atguigu.config.MainConfigofAutowired;
import com.liam.atguigu.dao.BookDao;
import com.liam.atguigu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:07
 **/
public class IOCTest_Autowired {
	AnnotationConfigApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(MainConfigofAutowired.class);

	@Test
	public void test01(){
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		BookDao bookDao = applicationContext.getBean(BookDao.class);
		System.out.println(bookDao);
		Boos boos = applicationContext.getBean(Boos.class);
		System.out.println(boos);
		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		applicationContext.close(); // 关闭容器
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String [] definations = applicationContext.getBeanDefinitionNames();
		for(String name : definations) {
			System.out.println(name);
		}
	}
}
