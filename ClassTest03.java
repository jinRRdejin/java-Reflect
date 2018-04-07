package com.jrr.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest03 {

	/**
	 *���䷽���Ļ�������
	 */
	public static void main(String[] args) {
		// �����ķ������
		A a = new A();
		Class<? extends A> a1 = a.getClass();

		//�����ķ������  
		//�õ����䷽��
		try {
//			Method method = a1.getMethod("print",new Class[]{int.class, int.class});
			Method m = a1.getMethod("print", int.class ,int.class);
			//  ͨ��m������з����ĵ���        print(10, 20);
			Object o = m.invoke(a1.newInstance(), new Object[]{10,20});
			System.out.println("=======================");
			
			//�õ������Ķ���Ȼ��ͨ��������÷���
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

