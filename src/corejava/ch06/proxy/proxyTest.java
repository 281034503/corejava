package corejava.ch06.proxy;

import java.lang.reflect.*;
import java.util.*;


//代理的使用
public class proxyTest {
	public static void main(String [] args) {
		Object[] elements=new Object[1000];
		
		//整数1的代理填充元素…1000
		for(int i=0;i<elements.length;i++) {
			Integer value=i+1;
			InvocationHandler handler=new TraceHandler(value);
			Object proxy=Proxy.newProxyInstance(null, new Class[] {Comparable.class},handler);
			elements[i]=proxy;
			
			
		}
		
		//构造一个随机整数
		Integer key=new Random().nextInt(elements.length)+1;
		
		//搜索关键
		int result=Arrays.binarySearch(elements, key);
		//打印匹配到的
		if(result>=0)System.out.println(elements[result]);
	}

}


class TraceHandler implements InvocationHandler{
	
	private Object target;
	
	
	public TraceHandler(Object t) {
		target=t;
		
	}
	
	public Object invoke(Object proxy,Method m,Object [] args)throws Throwable{
		
		//打印隐式参数
		System.out.println(target);
		
		//打印方法名字
		System.out.println("."+m.getName()+"(");
		
		//打印显式参数
		if(args !=null) {
			for(int i=0;i<args.length;i++) {
				System.out.println(args[i]);
				if(i<args.length-1)
					System.out.println(", ");
			}
		}
		
		System.out.println(")");
		
		//调用实际的方法
		return m.invoke(target, args);
	}
}
