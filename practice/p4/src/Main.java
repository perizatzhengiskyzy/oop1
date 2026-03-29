package week9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Restaurant delpapa = new Restaurant(); 

       
        delpapa.servePizza(new Cat()); 
        delpapa.servePizza(new Student("Aidana", 3.9));

        System.out.println("--- Сортировка ---");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Arnur", 3.2));
        students.add(new Student("Alikhan", 3.8));
        students.add(new Student("Aruzhan", 3.5));

        
        Collections.sort(students);
        System.out.println("По GPA: " + students);

        
        Collections.sort(students, new NameComparator());
        System.out.println("По имени: " + students);
    }
}