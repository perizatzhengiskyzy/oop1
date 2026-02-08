package oop1.practice.p1;

import java.util.Scanner;

public class prog4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = b*b - 4 * a * c;
		double x1 , x2;
		if(d<0) {
			System.out.println("Error: discriminant < 0");
		}
		else if(d == 0) {
			x1 = (-b)/(2*a);
			System.out.println("Root: " + x1);
		}
		else {
			x1 = (-b + Math.sqrt(d))/(2*a);
			x2 = (-b - Math.sqrt(d))/(2*a);
			System.out.println("Roots: " + x1 + " "+ x2);
	            
	        }
	}

}