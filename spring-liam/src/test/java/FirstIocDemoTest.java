import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/13 17:44
 **/
public class FirstIocDemoTest {
	@Test
	void testIoc() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("first-ioc.xml");
		PeopleBean peopleBean = context.getBean("people",PeopleBean.class);
		String name = peopleBean.getName();
		System.out.println(name);
		assumeTrue(name.equals("zhangsan"));
	}

	@Test
	void testXmlBeanFactory() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("first-ioc.xml"));
		PeopleBean people = beanFactory.getBean("people",PeopleBean.class);
		String name = people.getName();
		System.out.println("name2:"+name);
		assumeTrue(name.equals("zhangsan"));
	}
}
