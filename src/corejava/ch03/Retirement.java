package corejava.ch03;

 // ������Ҫ�೤ʱ����ܴ洢һ���������ݽ�ÿ��������ͬ�����������ǹ̶���

import java.util.Scanner;

public class Retirement {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money do you need to retire?");//��Ҫ����Ǯ��������
		double goal = in.nextDouble();

		System.out.println("How much money will you contribute every year?");//ÿ���ܹ��׶���Ǯ
		double payment = in.nextDouble();

		System.out.println("Interest rate in %: ");//����
		double interestRate = in.nextDouble();

		double balance = 0;
		int years = 0;

		while (balance < goal) {

			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;

		}

		System.out.println("You can retire in " + years + "years.");

	}

}
