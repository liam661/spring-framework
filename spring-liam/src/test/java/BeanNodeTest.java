import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/16 10:09
 **/
public class BeanNodeTest {
	@Test
	public void testBean() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("META-INF/bean-node.xml");
		Object people = context.getBean("people");
		context.close();
	}
}
