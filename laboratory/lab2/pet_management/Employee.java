package pet_management;

public class Employee extends Person {
    private String position;
    private double salary;
    
    public Employee(String name, int age, String position, double salary) {
        super(name, age);
        this.position = position;
        this.salary = salary;
    }
    
    public String getPosition() {
        return position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    protected boolean canHavePet(Animal pet) {
        // Сотрудники могут иметь любых животных
        return true;
    }
    
    @Override
    public String getOccupation() {
        return "Employee: " + position;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + position + ", $" + salary;
    }
}