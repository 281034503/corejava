package corejava.ch05.arrays;

import java.util.*;
import java.lang.reflect.*;

//演示了如何使用反射来操作数组。
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
		//运行时badCopyOf的返回值转换会抛出一个异常
		//应该将goodCopyOf的参数声明为Object类型，不能声明对象型数组（Object[]）
	    //整型数组类型int[]可以被转换成Object,但是不能转换成对象数组
	}

	/*
	 * 该方法试图通过分配一个新数组并复制所有元素来生成数组。
	 * 
	 * @param是一个要增长的数组
	 * 
	 * @param newLength新的长度
	 * 
	 * @返回包含所有元素的较大数组，但是返回的数组有 类型对象[]，与a类型不相同
	 */

	public static Object[] badCopyOf(Object[] a, int newLength) { // 不是有用的
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}

	/*
	 * 这个方法通过分配一个相同类型的新数组来增长一个数组 复制所有元素。 复制所有元素
	 * 
	 * @ param是一个要增长的数组。这可以是一个对象数组，也可以是一个原语 类型数组 类型数组
	 * 
	 * @返回包含所有元素的更大数组。
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
