package corejava.ch06.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);

		Arrays.sort(staff);

		//打印所有员工对象的信息
		for (Employee e : staff)  //遍历数组staff中所有的元素，把每个元素赋给e
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

	}

}
