package corejava.ch07.exceptional;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;
   
public class ExceptionalTest {
	public static void main(String[] args) {
		int i = 0;
		int ntry = 10000000;
		Stack<String> s = new Stack<>();
		long s1;
		long s2;

		// ����һ�ѿյ�ntryʱ��
		System.out.println("Testing for empty stack");
		s1 = new Date().getTime();
		for (i = 0; i <= ntry; i++)
			if (!s.empty())
				s.pop();
		s2 = new Date().getTime();
		System.out.println((s2 - s1) + "milliseconds");

		
		// ����һ���ն�ջntryʱ�䣬������������쳣
		System.out.println("Catching EmptyStackException");
		s1 = new Date().getTime();
		for (i = 0; i <= ntry; i++) {
			try {
				s.pop();

			} catch (EmptyStackException e) {

			}

		}
		s2 = new Date().getTime();
		System.out.println((s2 - s1) + "milliseconde");
	}

}
