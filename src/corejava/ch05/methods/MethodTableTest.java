package corejava.ch05.methods;

import java.lang.reflect.Method;

public class MethodTableTest {
	
	public static void main(String [] args)throws Exception{
		
		//get方法指针指向正方形和sqrt方法
		Method square=MethodTableTest.class.getMethod("square", double.class);
		Method sqrt=Math.class.getMethod("sqrt", double.class);
		
		//打印x和y值的表
		printTable(1,10,10,square);
		printTable(1,10,10,sqrt);
	
	}
	
	public static double square(double x) {
		return x*x;
	}
	
	
	//在一个方法中打印一个带有x和y值的表
	public static void printTable(double from,double to,int n,Method f) {
		//将该方法打印为表格标题
		System.out.println(f);
		double dx=(to-from)/(n-1);
		for(double x=from;x<=to;x+=dx) {
			try {
				double y=(Double)f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n", x, y);
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	}
}
