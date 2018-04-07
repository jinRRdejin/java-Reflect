package com.jrr.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassTest02 {
	
	/*
	 * 获取类的方法
	 * 
	 */
	public static void printClassMethodMessage(Object obj) {
		// 获取类的信息，首先获取的类的类类型
		Class c = obj.getClass();
		// 获取类的名称
		System.out.println("类的名称为：" + c.getName());
		/*
		 * Method类是方法的对象，一个成员方法就是method对象 getMethods方法获取的是所有public 方法，包括从父类继承而来的
		 * c.getDeclaredMethods();获取的是该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();

		for (int i = 0; i < ms.length; i++) {
			// 得到方法的返回值类类型
			Class returnType = ms[i].getReturnType();
			System.out.println("得到方法返回值类型：" + returnType.getName());
			// 得到方法名
			System.out.print("得到方法名" + ms[i].getName() + "(");
			// 得到参数-->得到参数列表的类型的 类类型
			Class[] paraType = ms[i].getParameterTypes();
			for (Class class1 : paraType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
	/*
	 * 获取类成员变量
	 * 
	 */
	public static void printClassFieldMseeage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象 java.lang.reflect.field field封装了关于成员变量的操作
		 * getField的是所有的public 类型的成员变量 c.getDeclaredFields()获取的是所有该类自己生命的成员变量的信息
		 */
		// Field[] field = c.getFields();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			// 得到成员变量的类类型
			Class fieldType = field.getType();
			String ft = fieldType.getName();// 成员变量的类型
			// 得到成员变量的名称
			String fieldname = field.getName();
			System.out.println(fieldType + " " + fieldname);
		}

	}
	/*
	 * 获取类构造方法
	 * 
	 */
	public static void printClassConMessage(Object obj){
		Class c = obj.getClass();
		/*
		 * 构造方法也是对象
		 * java.long.Constructor封装了构造函数的信息
		 * getConstructors获取public修饰的构造方法
		 * getDeclaredConstructor获取所有构造方法
		 */
//		Constructor[]  con = c.getConstructors();
		Constructor[]  cons  = c.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.print("构造函数方法名：" + constructor.getName() + "( ");
			//构造方法没有返回值类型  直接获取方法参数
			Class[] conpara = constructor.getParameterTypes();
			for (Class class1 : conpara) {
				System.out.print(class1 + ",");
			}
			System.out.println(")");
			
		}
	}

}
