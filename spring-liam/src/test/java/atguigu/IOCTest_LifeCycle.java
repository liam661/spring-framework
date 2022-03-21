package atguigu;

import com.liam.atguigu.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:07
 **/
public class IOCTest_LifeCycle {
	@Test
	public void test01(){
		// 创建IOC容器
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");
		applicationContext.close(); // 关闭容器
	}
}
