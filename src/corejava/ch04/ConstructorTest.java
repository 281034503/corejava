package corejava.ch04;

import java.util.Random;

public class ConstructorTest {
	public static void main(String[] args) {

		// ��staff�������������Employee����
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry", 40000);
		staff[1] = new Employee(60000);
		staff[2] = new Employee();

		// ��ӡ��������Ա���������Ϣ
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());

	}

}

class Employee{

	private static int nextId;
	private int id;
	private String name = "";// ʵ�����ʼ��
	private double salary;

	static { // ��̬��ʼ����
		Random generator = new Random();
		nextId = generator.nextInt(10000); // ��nextId����Ϊ0��9999֮��������

	}
	
	

	{ // �����ʼ����
		id = nextId;
		nextId++;
	}

	
	
	public Employee(String n, double s) { // ���ع�����
		name = n;
		salary = s;
	}
	
	

	public Employee(double s) {
		// ����Employee(String��double)���캯��
		this("Employeeab #"+nextId,s);
	}

	
	
	public Employee() {// �޲���������

	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

}
