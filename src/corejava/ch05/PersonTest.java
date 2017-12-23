package corejava.ch05;

public class PersonTest {
	public static void main(String[] args) {

		Person[] people = new Person[2];
		people[0] = new Employeee("Harry Hacker", 50000, 1989, 10, 1);
		people[1] = new Student("Maria Morris", "Computer science");

		for (Person p : people)
			System.out.println(p.getName() + "," + p.getDescription());
	}

}
