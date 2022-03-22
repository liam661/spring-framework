package atguigu;

import com.liam.atguigu.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 20:07
 **/
public class IOCTest_Profile {
	AnnotationConfigApplicationContext applicationContext
			= new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

	@Test
	public void test01(){
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for(String type : namesForType){
			System.out.println(type);
		}
		System.out.println(dataSource);
		applicationContext.close(); // 关闭容器
	}
}
