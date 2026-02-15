package lab1.p5;

public class Person {
	private String name;
	private Gender gender;
	
	Person(String name , Gender gender){
		this.name = name;
		this.gender = gender;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " ("+gender+")";
	}
}

