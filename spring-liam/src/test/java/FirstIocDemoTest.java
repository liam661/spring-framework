import com.liam.ioc.pojo.PeopleBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/first-ioc.xml");
		PeopleBean peopleBean = context.getBean("people",PeopleBean.class);
		String name = peopleBean.getName();
		System.out.println(name);
		assumeTrue(name.equals("zhangsan"));
	}

	@Test
	void testXmlBeanFactory() {
		/*XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("META-INF/first-ioc.xml"));
		PeopleBean people = beanFactory.getBean("people",PeopleBean.class);
		String name = people.getName();
		System.out.println("name2:"+name);
		assumeTrue(name.equals("zhangsan"));*/

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.add("name", "javaboy");
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(PeopleBean.class, null, pvs);
		ctx.registerBeanDefinition("user",rootBeanDefinition);
		ctx.refresh();
		PeopleBean bean = ctx.getBean(PeopleBean.class);
		System.out.println(bean);
	}
}
