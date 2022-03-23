package com.liam.atguigu.condition;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/23 16:50
 **/

import com.liam.atguigu.aop.LogAspects;
import com.liam.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP
 * 	在程序运行期间动态的将某段代码切入到指定位置进行运行的编程方式
 * 	1.导入aop模块
 * 	2. 定义一个业务逻辑类：MathCalculator，在业务逻辑运行
 * 	3. 定义一个日志切面类（）：切面类里面的方法需要动态感知
 * 	  通知方法：
 * 		前置通知：(@Before)
 * 		后置通知：(@After) logEnd:（无论正常还是异常）
 * 	    返回通知：(@AfterReturning) logReturn 在目标方法正常返回之后运行
 * 		异常通知：(@After) logException 在目标方法出现异常以后运行
 * 		环绕通知：动态代理，手动推进目标方法运行（joinPoint.procced()）
 * 	4.
 * 	5. 将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 *	6. 必须告诉spring那个类是切面类,给切面类加上一个注解（@Aspect）
 *  7. 	给配置类加@EnableAspectJAutoProxy 开启基于注解的aop模式
 *  		在spring中有很多@EnableXXXX
 *
 *  三步：
 *  1） 将业务逻辑组件和切面类都加入到容器中：告诉spring那个切面类（@Aspect）
 *  2）在切面类上每个通知方法上标注通知注释，告诉spring 何时何地运行（切入点表达式）
 *  3） 开启基于注解的aop模式@EnableAspectJAutoProxy
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	// 业务逻辑类加入到容器中
	@Bean
	public MathCalculator calculator(){
		return new MathCalculator();
	}

	// 切面类加入到容器中
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}
