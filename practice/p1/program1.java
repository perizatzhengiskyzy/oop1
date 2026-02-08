package oop1.practice.p1;

import java.util.Scanner;

public class program1 {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	        System.out.print("name: ");
	        String name = input.nextLine();
	        int length = name.length();
	        
	        System.out.print("+");
	        for(int i = 0 ; i < length+2; i++) {
	        	System.out.print("-");
	        }
	        System.out.println("+");
	        
	        System.out.println("| " + name + " |");
	        
	        System.out.print("+");
	        for(int i = 0 ; i < length + 2 ; i++) {
	        	System.out.print("-");
	        }
	        System.out.print("+");
	}
}