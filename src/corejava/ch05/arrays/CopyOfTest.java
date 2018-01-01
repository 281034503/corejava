package corejava.ch05.arrays;

import java.util.*;
import java.lang.reflect.*;

//��ʾ�����ʹ�÷������������顣
public class CopyOfTest {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		a = (int[]) goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));

		String[] b = { "Tom", "Dick", "Harry" };
		b = (String[]) goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));

		System.out.println("The following call will generate an exception.");
		b = (String[]) badCopyOf(b, 10);
		//����ʱbadCopyOf�ķ���ֵת�����׳�һ���쳣
		//Ӧ�ý�goodCopyOf�Ĳ�������ΪObject���ͣ������������������飨Object[]��
	    //������������int[]���Ա�ת����Object,���ǲ���ת���ɶ�������
	}

	/*
	 * �÷�����ͼͨ������һ�������鲢��������Ԫ�����������顣
	 * 
	 * @param��һ��Ҫ����������
	 * 
	 * @param newLength�µĳ���
	 * 
	 * @���ذ�������Ԫ�صĽϴ����飬���Ƿ��ص������� ���Ͷ���[]����a���Ͳ���ͬ
	 */

	public static Object[] badCopyOf(Object[] a, int newLength) { // �������õ�
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}

	/*
	 * �������ͨ������һ����ͬ���͵�������������һ������ ��������Ԫ�ء� ��������Ԫ��
	 * 
	 * @ param��һ��Ҫ���������顣�������һ���������飬Ҳ������һ��ԭ�� �������� ��������
	 * 
	 * @���ذ�������Ԫ�صĸ������顣
	 * 
	 */

	public static Object goodCopyOf(Object a, int newLength) {
		Class cl = a.getClass();
		if (!cl.isArray())
			return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}

}
