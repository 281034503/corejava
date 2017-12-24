package corejava.ch05.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
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

	public boolean equals(Object otherObject) {
		if (this == otherObject)//快速测试，对象是否相同
			return true;

		if (otherObject == null)//如果显式参数为空，则必须返回false
			return false;

		if (getClass() != otherObject.getClass())//如果类不匹配，它们就不能相等
			return false;

		Employee other = (Employee) otherObject;//现在我们知道其他对象是非空雇员

		return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
        //测试字段是否具有相同的值
	}

	public int hashCode() {
		return Objects.hash(name, salary, hireDay);

	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";

	}

}
