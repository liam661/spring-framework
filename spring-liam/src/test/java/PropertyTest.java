import com.liam.ioc.pojo.PeopleBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 16:26
 **/
public class PropertyTest {
	@Test
	void testProperty(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-property.xml");
		PeopleBean peopleBean = context.getBean("people",PeopleBean.class);
		assert peopleBean.getName().equals("zhangsan");
	}
}
