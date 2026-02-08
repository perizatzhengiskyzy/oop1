package oop1.practice.p2;

public class prog2_lab2 {
	
	private String studentName;
	private int studentID;
	private int studentYOS;
	
	public prog2_lab2(String name, int id, int yos) {
		this.studentName = name;
		this.studentID = id;
		this.studentYOS = yos;
	}
	
	public void displayDetails() {
		System.out.println("Name - " + studentName);
		System.out.println("ID - " + studentID);
		System.out.println("Year of Study - " + studentYOS);
	}
	public void incrementID() {
		studentID+=1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prog2_lab2 stud = new prog2_lab2("Perizat", 24, 2024);
		
		stud.displayDetails();
		stud.incrementID();
		stud.displayDetails();		
	}

}
