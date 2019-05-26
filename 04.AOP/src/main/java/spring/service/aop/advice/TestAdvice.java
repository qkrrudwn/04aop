package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {
	
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("[before LOG]"+getClass()+".before() start.......");
		System.out.println("[before LOG] targetObject call method"+method);
		if(args.length != 0) {
			System.out.println("[before LOG] targetObject method ���� argument"+args[0]);
		}
		System.out.println("[before LOG]"+getClass()+".before() end.......");
		
	}
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("[after LOG]"+getClass()+".afterReturning() start.......");
		System.out.println("[after LOG] targetObject call method"+method);
		System.out.println("[after LOG] Ÿ�� ��ü�� ȣ���� return value : "+returnValue);
		System.out.println("[after LOG]"+getClass()+".afterReturning() end.......");
		
	}

	@Override
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
	
	public void afterThrowing(Throwable throwable) {
		
		System.out.println("[Exception]"+getClass()+".afterThrowing() start.......");
		System.out.println("[Exception] Exception �߻�");
		System.out.println("[Exception] Exception Message : "+throwable.getMessage());
		System.out.println("[Exception]"+getClass()+".afterThrowing() end.......");
	}

	
	

}
