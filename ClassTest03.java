package com.jrr.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest03 {

	/**
	 *反射方法的基本操作
	 */
	public static void main(String[] args) {
		// 方法的反射操作
		A a = new A();
		Class<? extends A> a1 = a.getClass();

		//反方的反射操作  
		//拿到反射方法
		try {
//			Method method = a1.getMethod("print",new Class[]{int.class, int.class});
			Method m = a1.getMethod("print", int.class ,int.class);
			//  通过m对象进行方法的调用        print(10, 20);
			Object o = m.invoke(a1.newInstance(), new Object[]{10,20});
			System.out.println("=======================");
			
			//拿到方法的对象。然后通过对象调用方法
			Method m1 = a1.getMethod("print", String.class,String.class );
			Object oo = m1.invoke(a1.newInstance(), "hello","WORLD");
			
			System.out.println("==========================");
//			Method m2 = a1.getMethod("print", new Class[]{});
			Method m2 = a1.getMethod("print");
//			m2.invoke(a1.newInstance(), new Object[]{});
			m2.invoke(a1.newInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
}

class A{
	public void print(){
		System.out.println("hello world");
	}
	public void print(int a,int b){
	System.out.println(a+b);	
	}
	public void print(String a, String b){
	System.out.println(a.toUpperCase() + b.toLowerCase());	
	}
}

