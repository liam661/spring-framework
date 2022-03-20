package com.liam.atguigu;

import com.liam.atguigu.bean.Person;
import com.liam.atguigu.config.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:00
 **/
@Configuration // 告诉spring这是一个配置类
/*@ComponentScan(value = "com.liam.atguigu",includeFilters = {
		*//*@ComponentScan.Filter(type = FilterType.ANNOTATION,
				classes = {Controller.class, Service.class}),*//*
		@ComponentScan.Filter(type=FilterType.CUSTOM,classes = {MyTypeFilter.class}
		)
}) // value :指定要扫描的包*/
@ComponentScans(value = {
		@ComponentScan(value = "com.liam.atguigu", includeFilters = {
				@ComponentScan.Filter(type = FilterType.CUSTOM,
						classes = {MyTypeFilter.class})
		},useDefaultFilters = false)
})
// FilterType.ANNOTATION,按照注解
// FilterType.ASSIGNABLE_TYPE,按照给定的类型
// FilterType.
public class MainConfig {
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}
}
