package pet_management;

public class Student extends Person {
    private String major;
    private int studentId;
    
    public Student(String name, int age, String major, int studentId) {
        super(name, age);
        this.major = major;
        this.studentId = studentId;
    }
    
    public String getMajor() {
        return major;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    @Override
    protected boolean canHavePet(Animal pet) {
        // Студенты тоже могут иметь любых животных
        return true;
    }
    
    @Override
    public String getOccupation() {
        return "Student: " + major;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + major + ", ID: " + studentId;
    }
}