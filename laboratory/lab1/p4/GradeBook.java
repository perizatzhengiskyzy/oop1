package lab1.p4;

import java.util.* ;

import lab1.lab2.Student;

public class GradeBook {
	private Course course;
    private List<Student> students;
    private Map<Student, Integer> grades;
    
    GradeBook(Course course , List<Student> students){
    	this.grades = new HashMap<>();
    	this.course = course;
    	this.students = students;
    }
    
    public void displayMessage() {
    	System.out.println("Welcome to "+ course.getName()+ "!");
    	System.out.println(course.getDescription());
    }
    
    public void inputGrades() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Please input grade for students(0-100");
    	for(Student s : students) {
    		System.out.println("Enter the grade for "+s.getInfo() + " student:");
    		int grade = scanner.nextInt();
    		while(grade<0 || grade>100) {
    			System.out.print("Invalid grade! Enter 0-100: ");
    			grade = scanner.nextInt();
    		}
    		grades.put(s, grade);
    	}
    }
    
    public void displayGradeReport() {
    	determineClassAverage();
    	determineHighestGrade();
        determineLowestGrade();
        outputBarChart();
    }
    
    public void determineClassAverage() {
    	int sum = 0 , count = 0 ;
    	for(int v : grades.values()) {
    		sum+=v;
    		count+=1;
    	}
    	System.out.print("Class average is "+(sum/count) + " . ");
    }
    
    public void determineHighestGrade() {
    	int mx = Collections.max(grades.values()) ;
    	Student highest=null;
    	for(Student s : students) {
    		if(grades.get(s)==mx) {
    			highest = s;
    		}
    	}
    	System.out.print("Highest grade is " + mx + "( " + highest.getInfo() + " )");
    }
    
    public void determineLowestGrade() {
    	int min = Collections.min(grades.values());
    	Student lowest = null;
    	for(Student s : students) {
    		if(grades.get(s) == min) {
    			lowest = s;
    		}
    	}
    	System.out.print("Lowest grade is " + min + " ( " + lowest.getInfo() +")");
    }
    
    public void outputBarChart() {
    	System.out.println("Grades distribution: ");
    	int[] ranges = new int[11];
    	for(int g : grades.values()) {
    		int v = g/10;
    		ranges[v]+=1;
    	}
    	for(int i = 0 ; i < ranges.length; i++) {
    		if(i==10) {
    			System.out.printf("100: ");
    			
    		}
    		else {
    			System.out.printf("%02d-%02d " ,i*10 , i*10+9);
    		}
    		for(int j = 0 ; j < ranges[i]; j++) {
    			System.out.print("*");
    		}
    		System.out.println();
    	}
    }
    
    @Override
    public String toString() {
        return "GradeBook for course: " + course.getName() + ", Students: " + students.size();
    }
    
}

