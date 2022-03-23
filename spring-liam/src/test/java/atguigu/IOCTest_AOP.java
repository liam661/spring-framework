package atguigu;

import com.liam.atguigu.MainConfig;
import com.liam.atguigu.aop.MathCalculator;
import com.liam.atguigu.bean.Boos;
import com.liam.atguigu.bean.Car;
import com.liam.atguigu.bean.Color;
import com.liam.atguigu.condition.MainConfigOfAop;
import com.liam.atguigu.config.MainConfigofAutowired;
import com.liam.atguigu.dao.BookDao;
import com.liam.atguigu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:07
 **/
public class IOCTest_AOP {
	AnnotationConfigApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(MainConfigOfAop.class);

	@Test
	public void test01(){
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(4,2);
		applicationContext.close(); // 关闭容器
	}
}
