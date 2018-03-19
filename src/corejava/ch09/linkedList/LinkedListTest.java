package corejava.ch09.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//链表
public class LinkedListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");

		List<String> b = new LinkedList<>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");

		// 把b的单词合并成a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();

		while (bIter.hasNext()) {
			if (aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);

		// 从b中删除每一个单词
		bIter = b.iterator();
		while (bIter.hasNext()) {
			bIter.next();
			if (bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);

		
		// 批量操作：从A中删除B中的所有单词
		a.removeAll(b);
		System.out.println(a);

	}

}
