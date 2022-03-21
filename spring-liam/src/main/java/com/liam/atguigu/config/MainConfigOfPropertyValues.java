package com.liam.atguigu.config;

import com.liam.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 21:57
 **/
//使用@PropertySource 读取外部配置文件中的k-v保存到运行的环境变量中；
// 加载完外部的配置
@PropertySource(value = {"classpath:/META-INF/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
	@Bean
	public Person person(){
		return new Person();
	}
}
