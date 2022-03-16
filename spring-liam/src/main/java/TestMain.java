import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/13 17:40
 **/
public class TestMain {
	public static void main(String[] args) {
		ApplicationContext acx = new AnnotationConfigApplicationContext(TestConfig.class);
		Object name = acx.getBean("name");
		System.out.println(name);
	}
}
