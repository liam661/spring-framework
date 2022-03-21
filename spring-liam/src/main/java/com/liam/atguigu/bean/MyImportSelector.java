package com.liam.atguigu.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/21 17:17
 **/
public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值：就是导入到容器中的组件全类名
	 * @param importingClassMetadata 当前标注@Import注解类的所有注解信息
	 * @return
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.liam.atguigu.bean.Blue","com.liam.atguigu.bean.Red"};
	}
}
