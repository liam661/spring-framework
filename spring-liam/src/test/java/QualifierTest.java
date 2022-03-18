import com.liam.ioc.pojo.PeopleBean;
import com.liam.ioc.pojo.PeopleBeanTwo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/18 17:00
 **/
public class QualifierTest {
	@Test
	void testQualifier() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/spring-qualifier.xml");
		PeopleBeanTwo peopleTwo = context.getBean("p2", PeopleBeanTwo.class);
		PeopleBean peopleOne = context.getBean("peopleBean", PeopleBean.class);
		assert peopleTwo.getPeopleBean().equals(peopleOne);
	}
}
