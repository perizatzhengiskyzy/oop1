package lab1.lab2;

public class Student {
    private int id;
    private String name;
    private int yearOfStudy;


    public Student(int id, String name, int yearOfStudy) {
        this.id = id;
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

    public String getInfo() {
        return "ID: " + id + ", Name: " + name;
    }


    public void increaseYear() {
        yearOfStudy += 1;
    }

    public static void main(String[] args) {
        Student student = new Student(101, "Алтынай", 1);

        System.out.println(student.getInfo());

        System.out.println("Current year of study: " + student.yearOfStudy);

        student.increaseYear();
        System.out.println("After increment: " + student.yearOfStudy);
    }
}