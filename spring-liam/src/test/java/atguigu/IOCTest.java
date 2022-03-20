package atguigu;

import com.liam.atguigu.MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:02
 **/
public class IOCTest {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);
		String [] definations = applicationContext.getBeanDefinitionNames();
		for(String name : definations){
			System.out.println(name);
		}
	}
}
