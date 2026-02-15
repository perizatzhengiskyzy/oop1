package com.example.lab.p1;

import java.util.Scanner;

public class Analyzer {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		problem1 data = new problem1();
		
		while (true) {
			System.out.print("Enter number (Q to quit): ");
			String input = scanner.next();
			
			if (input.equalsIgnoreCase("Q")) {
				break;
			}
			
			try {
				double number = Double.parseDouble(input);
				data.add(number);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number or Q");
			}
		}
		
		System.out.println("Average = " + data.getAverage());
		System.out.println("Maximum = " + data.getMaximum());
		
		scanner.close();
	}

}
