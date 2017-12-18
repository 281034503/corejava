package corejava.ch04;

import java.time.*;

public class EmployeeTest {
	public static void main(String[] args) {

		Employeey[] staff = new Employeey[3];

		staff[0] = new Employeey("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employeey("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employeey("Tony Tester", 40000, 1990, 3, 15);

		for (Employeey e : staff)
			e.raiseSalary(5);

		for (Employeey e : staff)
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
	}

}

class Employeey {

	private String name;
	private double salary;
	private LocalDate hireDay;

	public Employeey(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
