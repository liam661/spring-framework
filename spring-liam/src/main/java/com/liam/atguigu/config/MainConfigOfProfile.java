package com.liam.atguigu.config;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/22 16:58
 **/

import com.liam.atguigu.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * profile:
 * 	spring 为我们提供的可以根据当前环境，动态激活和切换一些列组件的功能
 * 	开发环境：测试环境、生产环境
 * 	数据源：A、B、C
 * @profile: 指定组件在那个环境的情况下才能被注册到容器中，不指定 任何环境都能注册
 *	1） 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
 *  2） 写在配置类上，只是指定环境的时候整个配置类里面的所有配置才能生效
 *  3）没有标注,默认会生效
 */
@PropertySource("classpath:META-INF/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
	@Value("${da.user}")
	private String user;

	private StringValueResolver valueResolver;

	private String driverClass;

	@Profile("test")
	@Bean
	public Yellow yellow(){
		return new Yellow();
	}
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.valueResolver = resolver;
		driverClass = valueResolver.resolveStringValue("${db.driverClass}");
	}

	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("{db.password}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/runnoob_test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("{db.password}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/runnoob_dev");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
}
