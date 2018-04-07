package com.jrr.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassTest02 {
	
	/*
	 * ��ȡ��ķ���
	 * 
	 */
	public static void printClassMethodMessage(Object obj) {
		// ��ȡ�����Ϣ�����Ȼ�ȡ�����������
		Class c = obj.getClass();
		// ��ȡ�������
		System.out.println("�������Ϊ��" + c.getName());
		/*
		 * Method���Ƿ����Ķ���һ����Ա��������method���� getMethods������ȡ��������public �����������Ӹ���̳ж�����
		 * c.getDeclaredMethods();��ȡ���Ǹ����Լ������ķ��������ʷ���Ȩ��
		 */
		Method[] ms = c.getMethods();

		for (int i = 0; i < ms.length; i++) {
			// �õ������ķ���ֵ������
			Class returnType = ms[i].getReturnType();
			System.out.println("�õ���������ֵ���ͣ�" + returnType.getName());
			// �õ�������
			System.out.print("�õ�������" + ms[i].getName() + "(");
			// �õ�����-->�õ������б�����͵� ������
			Class[] paraType = ms[i].getParameterTypes();
			for (Class class1 : paraType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
	/*
	 * ��ȡ���Ա����
	 * 
	 */
	public static void printClassFieldMseeage(Object obj) {
		Class c = obj.getClass();
		/*
		 * ��Ա����Ҳ�Ƕ��� java.lang.reflect.field field��װ�˹��ڳ�Ա�����Ĳ���
		 * getField�������е�public ���͵ĳ�Ա���� c.getDeclaredFields()��ȡ�������и����Լ������ĳ�Ա��������Ϣ
		 */
		// Field[] field = c.getFields();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			// �õ���Ա������������
			Class fieldType = field.getType();
			String ft = fieldType.getName();// ��Ա����������
			// �õ���Ա����������
			String fieldname = field.getName();
			System.out.println(fieldType + " " + fieldname);
		}

	}
	/*
	 * ��ȡ�๹�췽��
	 * 
	 */
	public static void printClassConMessage(Object obj){
		Class c = obj.getClass();
		/*
		 * ���췽��Ҳ�Ƕ���
		 * java.long.Constructor��װ�˹��캯������Ϣ
		 * getConstructors��ȡpublic���εĹ��췽��
		 * getDeclaredConstructor��ȡ���й��췽��
		 */
//		Constructor[]  con = c.getConstructors();
		Constructor[]  cons  = c.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.print("���캯����������" + constructor.getName() + "( ");
			//���췽��û�з���ֵ����  ֱ�ӻ�ȡ��������
			Class[] conpara = constructor.getParameterTypes();
			for (Class class1 : conpara) {
				System.out.print(class1 + ",");
			}
			System.out.println(")");
			
		}
	}

}
