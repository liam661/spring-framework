import com.liam.ioc.pojo.PeopleBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 15:49
 **/
public class ConstructArgTest {

	@Test
	void testConstructArg(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-constructor-arg.xml");
		PeopleBean peopleBean = context.getBean("people2", PeopleBean.class);
		assert peopleBean.getName().equals("zhangsan");

	}
}
