import com.liam.ioc.pojo.Apple;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 14:50
 **/
public class ReplaceMethodTest {
	@Test
	void testReplaceMethod(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-replaced-method.xml");
		Apple apple = context.getBean("apple",Apple.class);
		apple.hello();
	}
}
