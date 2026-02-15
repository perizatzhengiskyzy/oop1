package lab1.p2;

public class main {
    public static void main(String[] args) {

        problem2 e1 = new problem2("Alice", problem2.Position.DEVELOPER);
        problem2 e2 = new problem2("Bob", problem2.Position.MANAGER, 50000);

        e1.raiseSalary(2000);
        e2.raiseSalary(10, true);

        System.out.println(e1);
        System.out.println(e2);

        System.out.println("Total employees: " + problem2.getEmployeeCount());
    }

}
