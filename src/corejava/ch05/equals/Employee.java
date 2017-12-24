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
		if (this == otherObject)//���ٲ��ԣ������Ƿ���ͬ
			return true;

		if (otherObject == null)//�����ʽ����Ϊ�գ�����뷵��false
			return false;

		if (getClass() != otherObject.getClass())//����಻ƥ�䣬���ǾͲ������
			return false;

		Employee other = (Employee) otherObject;//��������֪�����������Ƿǿչ�Ա

		return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
        //�����ֶ��Ƿ������ͬ��ֵ
	}

	public int hashCode() {
		return Objects.hash(name, salary, hireDay);

	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";

	}

}
