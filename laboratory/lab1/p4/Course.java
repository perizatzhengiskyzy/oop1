package lab1.p4;

import java.util.List;

public class Course {
	private String name;
	private String description;
	private int numberOfCredits;
	private List<String> prerequisite;
	
	Course(String name ,String description , int numberOfCredits , List<String> prepequisite){
		this.name = name ;
		this.description = description;
		this.numberOfCredits = numberOfCredits;
		this.prerequisite = prerequisite;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getCredits() {
		return numberOfCredits;
	}
	public List<String> getPrerequisites() { return prerequisite; }
	
	@Override
	public String toString() {
		return "Course: " + name + ", " + description + ", Credits: " + numberOfCredits + ", Prerequisites: " + prerequisite;
    
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
