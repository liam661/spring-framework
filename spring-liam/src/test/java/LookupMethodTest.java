import com.liam.ioc.pojo.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 14:21
 **/
public class LookupMethodTest {

	@Test
	public void testLookupMethodBean() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-lookup-method.xml");
		Shop shop = context.getBean("shop", Shop.class);
		System.out.println(shop.getFruits().getName());
		assert context.getBean("apple").equals(shop.getFruits());
	}
}
