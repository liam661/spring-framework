package atguigu;

import com.liam.atguigu.bean.Yellow;
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

	// 1.使用命令行动态参数: 在虚拟参数位置加载-Dspring.profiles.active=dev
	// 2. 代码方式

	@Test
	public void test01(){
//		DataSource dataSource = applicationContext.getBean(DataSource.class);

		// 1 创建一个appliContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 2 设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		// 3 注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		// 启动刷新容器
		applicationContext.refresh();

		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for(String type : namesForType){
			System.out.println(type);
		}
		Yellow yellow = applicationContext.getBean(Yellow.class);
		System.out.println(yellow);
		this.applicationContext.close(); // 关闭容器
	}
}
