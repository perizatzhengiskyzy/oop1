package oop1.practice.p1;

import java.util.Scanner;

public class prog6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		String reversed = new StringBuilder(st).reverse().toString();
		if(reversed.equals(st)) {
			System.out.print("YES");
		}
		else {
			System.out.print("NO");

		}

	}

}
