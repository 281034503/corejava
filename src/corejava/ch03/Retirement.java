package corejava.ch03;

 // 计算需要多长时间才能存储一定量的退休金，每年存入的相同数量金额，利率是固定的

import java.util.Scanner;

public class Retirement {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money do you need to retire?");//需要多少钱才能退休
		double goal = in.nextDouble();

		System.out.println("How much money will you contribute every year?");//每年能贡献多少钱
		double payment = in.nextDouble();

		System.out.println("Interest rate in %: ");//利率
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
