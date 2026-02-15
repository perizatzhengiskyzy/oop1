package lab1.p4;
import java.util.*;

import lab1.lab2.Student;

public class GradeBookTest {
	
	public static void main(String[] args) {
		Course course = new Course(
	            "CS101 Object-oriented Programming",
	            "Introduction to OOP concepts",
	            3,
	            Arrays.asList("CS100 Basics of Programming")
	        );
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Aruzhan", 1));
		students.add(new Student(2, "Perizat", 2));
		students.add(new Student(3, "Aigerim", 3));
		students.add(new Student(4, "Dana", 4));
		students.add(new Student(5, "Madina", 5));
		
		GradeBook gradeBook = new GradeBook(course , students);
		
		 gradeBook.displayMessage();

	        // Ввод оценок
	     gradeBook.inputGrades();

	        // Отчёт
	     gradeBook.displayGradeReport();
	    }

	}


