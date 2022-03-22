package com.liam.atguigu.config;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/22 16:58
 **/

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * profile:
 * 	spring 为我们提供的可以根据当前环境，动态激活和切换一些列组件的功能
 * 	开发环境：测试环境、生产环境
 * 	数据源：A、B、C
 * @profile: 指定组件在那个环境的情况下才能被注册到容器中，不指定 任何环境
 */
@PropertySource("classpath:META-INF/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
	@Value("${da.user}")
	private String user;

	private StringValueResolver valueResolver;

	private String driverClass;

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.valueResolver = resolver;
		driverClass = valueResolver.resolveStringValue("${db.driverClass}");
	}

	@Bean("testDataSource")
	public DataSource dataSource(@Value("{db.password}") String pwd) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/runnoob");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
}
