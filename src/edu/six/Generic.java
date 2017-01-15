package edu.six;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {

	public static void main(String[] args) {
		List list = new ArrayList();
		List<String> list1 = new ArrayList<String>();
		
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		list1.add("hello");
//		list1.add(20);加不进去
		System.out.println(c1==c2);//true
		
		//反射的操作都是编译之后的操作
		
		/*
		 * c1==c2,true,说明编译之后,集合的泛型是去泛型化的
		 * java中集合的泛型，设计防止输入错误的，只在编译阶段有效
		 * 绕过编译就无效了
		 * 验证：我们可以通过方法的反射来操作，绕过编译
		 */
		try{
			Method m = c2.getMethod("add", Object.class);
			Object o = m.invoke(list1, 20);
			System.out.println(list1.size());
			System.out.println(list1);
			
//			for (String string : list1) {
//				现在不能这样遍历
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
