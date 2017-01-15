/*
 * 2016.10.19
 */

package edu.one;

public class ClassDemo1 {

	public static void main(String[] args) {
		//Foo的实例如何表示
		Foo foo1 = new Foo();
		
		//Foo这个类 也是一个实例对象，是Class类的实例对象！！！
		//任何一个类都是Class的实例对象，有三种表示方式
		
		//1.任何一个类都有一个隐含的静态成员变量class
		Class c1 = Foo.class;
		
		//2.已知该类的对象，通过getClass方法
		Class c2 =  foo1.getClass();
		
		/*c1 c2表示了Foo类的类类型
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们成为该类的类类型
		 */
		
		//不管c1 c2，都代表了Foo类的类类型，一个类只可能Class类的一个实例对象！！！
		System.out.println(c1==c2);//true
		
		//3. 
		Class c3 = null;
		try {
			c3 = Class.forName("edu.one.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2==c3);//true
		
		//我们完全可以通过类的类类型创建该类的对象：通过c1 c2 c3创建Foo对象
		try {
			Foo foo = (Foo) c1.newInstance();//需要无参的构造方法
			foo.print();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}

class Foo{
	public void print() {
		System.out.println("I'm Foo");
	}
	
}