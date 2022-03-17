import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/14 11:37
 **/
public class ImportNodeTest {
	@Test
	void testImportNode(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("META-INF/import-beans.xml");
		context.close();
	}
}
