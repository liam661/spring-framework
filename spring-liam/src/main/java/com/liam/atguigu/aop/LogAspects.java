package com.liam.atguigu.aop;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/23 16:54
 **/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
public class LogAspects {
	// 抽取公共的切入点表动式
	@Pointcut("execution(public int com.liam.atguigu.aop.MathCalculator.*(..))")
	public void pointCut(){}

	//@Before 在目标方法之前切入，切入点表达式（指定在那个方法切入）
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName()+
				"运行...参数列表是：{"+ Arrays.toString(args) +"}");
	}

	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"结束...");
	}

	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName()+"正常返回 ...运行结果是{"+result+"}");
	}
	// JoinPoint 必须是第一个参数
	@AfterThrowing(value = "pointCut()",throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception){
		System.out.println(joinPoint.getSignature().getName()+"异常.. 抛出异常 异常信息:{"+exception+"}");
	}
}
