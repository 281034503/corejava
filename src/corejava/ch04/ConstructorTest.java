package corejava.ch04;

import java.util.Random;

public class ConstructorTest {
	public static void main(String[] args) {

		// 在staff数组中填充三个Employee对象
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry", 40000);
		staff[1] = new Employee(60000);
		staff[2] = new Employee();

		// 打印关于所有员工对象的信息
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());

	}

}

class Employee{

	private static int nextId;
	private int id;
	private String name = "";// 实例域初始化
	private double salary;

	static { // 静态初始化块
		Random generator = new Random();
		nextId = generator.nextInt(10000); // 将nextId设置为0到9999之间的随机数

	}
	
	

	{ // 对象初始化块
		id = nextId;
		nextId++;
	}

	
	
	public Employee(String n, double s) { // 重载构造器
		name = n;
		salary = s;
	}
	
	

	public Employee(double s) {
		// 调用Employee(String，double)构造函数
		this("Employeeab #"+nextId,s);
	}

	
	
	public Employee() {// 无参数构造器

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
