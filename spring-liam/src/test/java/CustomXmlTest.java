import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xsd.UserXsd;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/16 17:05
 **/
public class CustomXmlTest {

	@Test
	void testXmlCustom() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/custom-xml.xml");
		UserXsd testUserBean = context.getBean("testUserBean", UserXsd.class);
		assert testUserBean.getName().equals("huifer");
		assert testUserBean.getIdCard().equals("123");
		context.close();
	}
}

