package corejava.ch06.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);

		Arrays.sort(staff);

		//��ӡ����Ա���������Ϣ
		for (Employee e : staff)  //��������staff�����е�Ԫ�أ���ÿ��Ԫ�ظ���e
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

	}

}
