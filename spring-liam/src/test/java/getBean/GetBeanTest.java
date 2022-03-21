package getBean;

import com.liam.ioc.getBean.BeanSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/20 15:39
 **/
public class GetBeanTest {
	ClassPathXmlApplicationContext context = null;

	// junit5 出现的注解 相等Junit4中的 @Before，在所有的测试方法开始之前都执行一遍，与之对应的还有@After
	@BeforeEach
	void init(){
		context = new ClassPathXmlApplicationContext("META-INF/get-bean.xml");
	}

	@Test
	void fromBean() {
		BeanSource beanSource = context.getBean("beanSource", BeanSource.class);
		assert beanSource.getType().equals("xml");
	}

	@Test
	void fromStatic(){
		BeanSource beanSourceFromStatic = context.getBean("beanSourceFromStatic", BeanSource.class);
		assert beanSourceFromStatic.getType().equals("staticFactory");
	}

	@Test
	void fromNoStatic(){
		BeanSource beanSourceFromNoStatic = context.getBean("beanSourceFromNoStatic",BeanSource.class);
		assert beanSourceFromNoStatic.getType().equals("noStaticFactory");
	}

	@Test
	void fromFactoryBean(){
		BeanSource beanSourceFromFactoryBean = context.getBean("beaSourceFromFactoryBean",BeanSource.class);
		assert beanSourceFromFactoryBean.getType().equals("from factory bean");
	}
}
