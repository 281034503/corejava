package corejava.ch06.proxy;

import java.lang.reflect.*;
import java.util.*;


//�����ʹ��
public class proxyTest {
	public static void main(String [] args) {
		Object[] elements=new Object[1000];
		
		//����1�Ĵ������Ԫ�ء�1000
		for(int i=0;i<elements.length;i++) {
			Integer value=i+1;
			InvocationHandler handler=new TraceHandler(value);
			Object proxy=Proxy.newProxyInstance(null, new Class[] {Comparable.class},handler);
			elements[i]=proxy;
			
			
		}
		
		//����һ���������
		Integer key=new Random().nextInt(elements.length)+1;
		
		//�����ؼ�
		int result=Arrays.binarySearch(elements, key);
		//��ӡƥ�䵽��
		if(result>=0)System.out.println(elements[result]);
	}

}


class TraceHandler implements InvocationHandler{
	
	private Object target;
	
	
	public TraceHandler(Object t) {
		target=t;
		
	}
	
	public Object invoke(Object proxy,Method m,Object [] args)throws Throwable{
		
		//��ӡ��ʽ����
		System.out.println(target);
		
		//��ӡ��������
		System.out.println("."+m.getName()+"(");
		
		//��ӡ��ʽ����
		if(args !=null) {
			for(int i=0;i<args.length;i++) {
				System.out.println(args[i]);
				if(i<args.length-1)
					System.out.println(", ");
			}
		}
		
		System.out.println(")");
		
		//����ʵ�ʵķ���
		return m.invoke(target, args);
	}
}
