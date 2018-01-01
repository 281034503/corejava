package corejava.ch05.objectAnalyzer;

import java.util.ArrayList;
//这个程序使用反射来监视对象
public class ObjectAnalyzerTest {
	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
			squares.add(i * i);
		System.out.println(new ObjectAnalyzer().toString(squares));

	}

}
