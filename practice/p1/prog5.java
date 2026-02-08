package oop1.practice.p1;

import java.util.Scanner;

public class prog5 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Balance: ");
		double n = sc.nextDouble();
		
		System.out.println("Percent: ");
		double m = sc.nextDouble();
		
		double newBalance = n + n * (m / 100.0);  
		System.out.println("New balance: " + newBalance);

	}

}
