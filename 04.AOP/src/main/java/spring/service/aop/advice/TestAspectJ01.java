package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspectJ01 {
	
	public TestAspectJ01() {
		System.out.println(":: TestAspectJ01 Default Constructor");
	}
	
	@Pointcut("execution (* *.getMessage(..))")
	public void work() {
		System.out.println("work() pointcut call.................");
	}
	
	@Before("work()")
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("[before LOG]"+getClass()+".before() start.......");
		System.out.println("[before LOG] targetObject call method"+method);
		if(args.length != 0) {
			System.out.println("[before LOG] targetObject method ���� argument"+args[0]);
		}
		System.out.println("[before LOG]"+getClass()+".before() end.......");
		
	}
	
	@AfterReturning(pointcut="work()", returning="returnValue")
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("[after LOG]"+getClass()+".afterReturning() start.......");
		System.out.println("[after LOG] targetObject call method"+method);
		System.out.println("[after LOG] Ÿ�� ��ü�� ȣ���� return value : "+returnValue);
		System.out.println("[after LOG]"+getClass()+".afterReturning() end.......");
		
	}
	
	@Around("work()")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("[Around before]"+getClass()+".invoke() start.......");
		System.out.println("[Around before] targetObject call method"+invocation.getMethod());
		if(invocation.getArguments().length != 0) {
			System.out.println("[Around before] targetObject method ���� argument"+invocation.getArguments()[0]);
		}
		
		Object obj = invocation.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȣ���� return value : "+obj);
		System.out.println("[Around after] "+getClass()+".invoke() end.....");
		
		return obj;
	}
	
	@AfterThrowing(pointcut="work()", throwing="throwable")
	public void afterThrowing(Throwable throwable) {
		
		System.out.println("[Exception]"+getClass()+".afterThrowing() start.......");
		System.out.println("[Exception] Exception �߻�");
		System.out.println("[Exception] Exception Message : "+throwable.getMessage());
		System.out.println("[Exception]"+getClass()+".afterThrowing() end.......");
	}

	
	

}
