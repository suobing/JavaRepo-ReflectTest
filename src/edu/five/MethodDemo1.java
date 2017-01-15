package edu.five;

import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		//要获取print(int,int)方法 1.
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2.获取方法  名称和参数列表决定
		 * getMethod获取public方法
		 * getDeclaredMethod自己声明
		 */
		try {
//			Method m = c.getMethod("print", new Class[]{int.class,int.class});
			Method m = c.getMethod("print", int.class,int.class);
			
			//方法的反射操作
			//a1.print(10,20);
			//方法的反射操作是用m对象来进行方法调用，和a1.print()调用效果一样
			//方法如果没有返回值返回null，有则返回具体返回值
//			Object o = m.invoke(a1, new Object[]{10,20});
			Object o = m.invoke(a1,10,20);
			System.out.println("====================");
			
			Method m1= c.getMethod("print", String.class,String.class);
			o = m1.invoke(a1, new Object[]{"suo","Bing"});

			System.out.println("====================");
//			Method m2= c.getMethod("print",new Class[]{});
			Method m2= c.getMethod("print");
//			o = m2.invoke(a1,new Object[]{});
			o = m2.invoke(a1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class A{
	
	public void print(){
		System.out.println("hello world");
	}
	public void print(int a ,int b){
		System.out.println(a+b);
	}
	
	public void print(String a,String b){
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}