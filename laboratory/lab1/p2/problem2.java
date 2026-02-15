package lab1.p2;

public class problem2 {

    public enum Position {
        INTERN,
        DEVELOPER,
        MANAGER
    }

    private static int employeeCounter = 0;
    public static final String COMPANY_NAME = "TechCorp";

    private final int id;
    private String name;
    private Position position;
    private double salary;

    {
        System.out.println("New employee object is being created...");
    }

    public problem2(String name, Position position) {
        this(name, position, 30000);
    }

    public problem2(String name, Position position, double salary) {
        this.id = ++employeeCounter;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void raiseSalary(double amount) {
        this.salary += amount;
    }

    public void raiseSalary(double amount, boolean isPercentage) {
        if (isPercentage) {
            this.salary += this.salary * amount / 100;
        } else {
            raiseSalary(amount);
        }
    }

    public static int getEmployeeCount() {
        return employeeCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + COMPANY_NAME + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }
}

	

