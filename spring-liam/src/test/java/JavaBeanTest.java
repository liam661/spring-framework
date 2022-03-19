import com.liam.ioc.live.LiveBean;
import com.liam.ioc.pojo.PeopleBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 14:49
 **/
public class JavaBeanTest {

	void javaBeanLifeCycle() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/live-bean.xml");
		LiveBean liveBean = context.getBean("liveBean", LiveBean.class);
		context.close();
	}

	@Test
	void testGenerateBean(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/generate-bean.xml");
		PeopleBean peopleBean = context.getBean("people", PeopleBean.class);
		System.out.println(peopleBean.getName());
		PeopleBean peopleBean2 = context.getBean("people2", PeopleBean.class);
		System.out.println(peopleBean2.getName());
		context.close();
	}


}
