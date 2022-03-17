import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/14 17:43
 **/
public class AliasNodeTest {
	@Test
	void testAlias(){
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("META-INF/alias-node.xml");
		Object people = context.getBean("people");
		Object p1 = context.getBean("p1");
		assert people.equals(p1);
	}
}
