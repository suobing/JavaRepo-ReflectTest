package edu.two;

public class Demo2 {
	//new创建对象，是静态加载类，在编译时刻就需要加载所有的可能使用到的类
	//通过动态加载类，可以解决该问题
	public static void main(String[] args) {
		try{
			//动态加载类，在运行时刻加载
			Class c = Class.forName("edu.two.Excel");
			OfficeAble office = (OfficeAble) c.newInstance();

			office.foo();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

interface OfficeAble{
	public void foo();
}

class Excel implements OfficeAble{
	@Override
	public void foo() {
		System.out.println("excel...start");
	}
}

class Word implements OfficeAble{

	@Override
	public void foo() {
		System.out.println("word...start");
	}
}

class Word2013 extends Word{
	/*
	 * 总结：

	1。父类引用指向子类对象，而子类引用不能指向父类对象。

	2。把子类对象直接赋给父类引用叫upcasting向上转型，向上转型不用强制转换。

	      如：Father f1 = new Son();

	3。把"指向子类对象"的父类引用赋给子类引用叫向下转型(downcasting)，要强制转换。

	   如：f1 就是一个指向子类对象的父类引用。把f1赋给子类引用s1即 Son s1 = (Son)f1；

	           其中f1前面的(Son)必须加上，进行强制转换。
	*/
//				Word2013 w = (Word2013)new Word();//编译通过，运行错误，cannot be cast
}