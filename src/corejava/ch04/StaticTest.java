package corejava.ch04;

public class StaticTest {

	public static void main(String[] args) {

		Employeea[] stafff = new Employeea[4];

		stafff[0] = new Employeea("Tom", 40000);
		stafff[1] = new Employeea("Dick", 60000);
		stafff[2] = new Employeea("Harry", 65000);
		

	}

}

class Employeea {
	private static int nextId = 1;
	private String name;
	private double salary;
	private int id;


	public Employeea(String n, double s) {  //������
		name = n;
		salary = s;
		id = 0;


	}

	public static int getNextId1() {
		return nextId;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId; // ��id����Ϊ��һ�����õ�id
		nextId++;
	}

	public static int getNextId() {
		return nextId; // ���ؾ�̬�ֶ�
	}

	
	public static void main(String[] args) {  //��Ԫ����
	 Employeea e= new Employeea("Harry", 50000);
	
		System.out.println(e.getName() + " " + e.getSalary());
	}

}