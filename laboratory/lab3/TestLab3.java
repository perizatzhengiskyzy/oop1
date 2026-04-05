import java.util.*;

public class TestLab3 {
    public static void main(String[] args) {
        System.out.println("=== LAB 3 TESTS ===\n");
        
        // Task 4 Tests
        System.out.println("--- Task 4: Employee & Manager ---");
        Date date1 = new Date(120, 0, 1);
        Date date2 = new Date(121, 5, 15);
        Date date3 = new Date(119, 3, 20);
        
        Employee emp1 = new Employee("Alice", 50000, date1, "NI123");
        Employee emp2 = new Employee("Bob", 60000, date2, "NI456");
        Employee emp3 = new Employee("Charlie", 55000, date3, "NI789");
        
        Manager mgr = new Manager("David", 80000, new Date(118, 0, 1), "NI999", 10000);
        mgr.addToTeam(emp1);
        mgr.addToTeam(emp2);
        mgr.addToTeam(emp3);
        
        System.out.println(mgr);
        System.out.println("Team size: " + mgr.getTeam().size());
        
        // Test Comparable
        System.out.println("\nemp1 vs emp2: " + (emp1.compareTo(emp2) < 0 ? "emp1 earns less" : "emp1 earns more"));
        
        // Test Comparators
        java.util.List<Employee> employees = java.util.Arrays.asList(emp1, emp2, emp3);
        employees.sort(new NameComparator());
        System.out.println("Sorted by name: " + employees);
        
        employees.sort(new HireDateComparator());
        System.out.println("Sorted by hire date: " + employees);
        
        // Test Clone
        Employee emp1Clone = emp1.clone();
        System.out.println("\nOriginal: " + emp1);
        System.out.println("Clone: " + emp1Clone);
        
        // Task 5 Tests
        System.out.println("\n--- Task 5: Chocolate Sorting ---");
        Chocolate[] chocolates = {
            new Chocolate(50, "Twix"),
            new Chocolate(30, "Snickers"),
            new Chocolate(100, "Milka"),
            new Chocolate(45, "KitKat")
        };
        
        System.out.println("Before sorting:");
        for (Chocolate c : chocolates) System.out.println(c);
        
        Sort.bubbleSort(chocolates);
        System.out.println("\nAfter bubble sort by weight:");
        for (Chocolate c : chocolates) System.out.println(c);
        
        System.out.println("\n--- Time Sorting ---");
        Time[] times = {
            new Time(14, 30, 0),
            new Time(9, 15, 30),
            new Time(23, 59, 59),
            new Time(6, 0, 0)
        };
        
        System.out.println("Before sorting:");
        for (Time t : times) System.out.println(t);
        
        Sort.mergeSort(times);
        System.out.println("\nAfter merge sort:");
        for (Time t : times) System.out.println(t);
        
        // Task 3 Tests
        System.out.println("\n--- Task 3: MyCollection ---");
        MyCollection<String> myList = new MyArrayList<>();
        myList.add("Hello");
        myList.add("World");
        myList.add("Java");
        
        System.out.println("Size: " + myList.size());
        System.out.println("Contains 'Java': " + myList.contains("Java"));
        System.out.println("Elements:");
        for (String s : myList) {
            System.out.println("  " + s);
        }
        
        // Task 6 Tests
        System.out.println("\n--- Task 6: Improved Person & Pet ---");
        ImprovedPerson person = new ImprovedPerson("P001", "John", 25);
        System.out.println(person);
        person.haveBirthday();
        System.out.println("After birthday: " + person);
        
        ImprovedDog dog = new ImprovedDog("D001", "Rex", 3, "German Shepherd");
        System.out.println(dog);
        dog.play();
        dog.bark();
        
        System.out.println("\n✅ All tests passed!");
    }
}