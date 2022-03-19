import com.liam.ioc.live.LiveBean;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 15:37
 **/
public class ClassTest {
	@Test
	void testClass() throws Exception{
		String className = "com.liam.ioc.live.LiveBean";
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		Class<?> aClass = contextClassLoader.loadClass(className);

		Object o2 = aClass.getDeclaredConstructor().newInstance();
		Constructor<?> constructor = aClass.getConstructor();
		Object o = constructor.newInstance();
		if(o instanceof LiveBean) {
			LiveBean o1 = (LiveBean) o;
			o1.setAddress("shanghai");
			System.out.println(o1.getAddress());
		}
	}
}
