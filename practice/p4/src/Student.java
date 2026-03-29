package week9;


public class Student extends Person implements CanHavePizza, CanHaveParty, Comparable<Student> {
 String name;
 double gpa;

public Student(String name, double gpa) {
     super(name);
     this.gpa = gpa;
 }

 @Override
 public void eatPizza() {
     System.out.println(name + " ест пиццу в компании друзей."); // [cite: 11]
 }

 @Override
 public void move() { System.out.println(name + " идет на занятия."); } // [cite: 24, 28]

 @Override
 public void dance() { System.out.println(name + " танцует на вечеринке!"); } // [cite: 25]


 @Override
 public int compareTo(Student other) {
     return Double.compare(this.gpa, other.gpa); // [cite: 68, 73]
 }

 @Override
 public String toString() {
     return name + " (GPA: " + gpa + ")";
 }
}
