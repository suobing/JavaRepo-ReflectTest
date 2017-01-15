package edu.three;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo3 {

	public static void main(String[] args) {
		/*
		 * 基本的数据类型，void关键字，都存在类类型
		 */
		Class c1 = int.class;//int的类类型
		Class c2 = String.class;//String类的类类型，String类字节码（自己发明的）
		Class c3 = double.class;
		Class c4 = Double.class;//不是一回事
		Class c5 = void.class;
		
//		System.out.println(c1.getName());
//		System.out.println(c2.getName());
//		System.out.println(c2.getSimpleName());//不含包名
		
//		String s ="hello";
//		ClassUtil.printClassMsg(s);
		
//		Integer i = 1;
//		ClassUtil.printClassMethodMsg(i);
		
//		ClassUtil.printFieldMsg(1);
//		ClassUtil.printFieldMsg(new Integer(1));
		ClassUtil.printConMsg("he");
	}

}

class ClassUtil{
	/**
	 * 打印类的信息：成员函数，变量
	 * @param obj 该对象所属类的信息
	 */
	public static void printClassMethodMsg(Object obj){
		//要获取类的信息，首先要获取类的类类型
		Class c =obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
		//获取类名称
		System.out.println("类的名称："+c.getName());
		/*
		 * Method类，是方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()获取的是的public方法，包括继承来的
		 * getDeclaredMethods()获取所有自己的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();
//		c.getDeclaredMethods();
		for(int i=0;i<ms.length;i++){
			//得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getSimpleName()+" ");
			//得到方法名称
			System.out.print(ms[i].getName()+"(");
			//获取参数类型：得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getSimpleName()+",");
			}
			System.out.println(")");
			
		}
		
	}

	public static void printFieldMsg(Object obj) {
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()
		 * getDeclaredFields()
		 */
		Class c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			//得到成员变量类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getSimpleName();
			//得到成员变量名称
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	/**
	 * 打印对象的构造方法的信息
	 * @param obj
	 */
	public static void printConMsg(Object obj){
		//首先要获取类类型
		Class c = obj.getClass();
		/*构造方法也是对象
		 * java.lang.Constructor中封装了构造方法的信息
		 * getConstructors获取所有的public的构造方法
		 * getDeclaredConstructor得到所有的构造方法
		 */
		Constructor[] cs = c.getConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");
			//获取参数列表
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getSimpleName()+",");
			}
			System.out.println(")");
		}
		
	}
}
