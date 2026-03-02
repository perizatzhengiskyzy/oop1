package pet_management;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PET MANAGEMENT SYSTEM ===\n");
        
        // Создаем людей
        Person john = new Employee("John", 30, "Engineer", 75000);
        Person alice = new PhDStudent("Alice", 26, "Computer Science", 12345, 
                                      "Artificial Intelligence", 3);
        Person bob = new Student("Bob", 22, "Biology", 67890);
        Person sarah = new PhDStudent("Sarah", 28, "Physics", 54321, 
                                      "Quantum Computing", 5);
        
        // Создаем животных
        Animal murka = new Cat("Murka", 5, true);
        Animal rex = new Dog("Rex", 3, "Golden Retriever");
        Animal tweety = new Bird("Tweety", 2, 15.5);
        Animal nemo = new Fish("Nemo", 1, "salt");
        
        // Создаем реестр
        PersonRegistry registry = new PersonRegistry();
        
        System.out.println("=== Assigning pets ===");
        john.assignPet(rex);           // John owns Rex
        bob.assignPet(tweety);          // Bob owns Tweety
        alice.assignPet(murka);          // Alice owns Murka (allowed)
        alice.assignPet(rex);            // Alice tries to own Rex (should fail)
        sarah.assignPet(nemo);           // Sarah owns Nemo (allowed)
        
        // Добавляем всех в реестр
        System.out.println("\n=== Adding to registry ===");
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);
        registry.addPerson(sarah);
        
        registry.printRegistry();
        
        // Тестируем отпуск
        System.out.println("\n=== Vacation Time ===");
        
        // John goes on vacation and leaves Rex with Alice
        System.out.println("\n--- John leaves Rex with Alice ---");
        john.leavePetWith(alice);  // Should fail? Alice is PhDStudent, can't take dogs
        
        // John leaves Rex with Bob instead
        System.out.println("\n--- John leaves Rex with Bob ---");
        john.leavePetWith(bob);
        
        System.out.println("\n--- Registry during vacation ---");
        registry.printRegistry();
        
        // John returns and retrieves Rex
        System.out.println("\n--- John returns and retrieves Rex ---");
        john.retrievePetFrom(bob);
        
        registry.printRegistry();
        
        // Тестируем поиск
        System.out.println("\n=== Search Functions ===");
        System.out.println("People with pets:");
        for (Person p : registry.findPeopleWithPets()) {
            System.out.println("  " + p.getName() + " has: " + p.getPet().getName());
        }
        
        System.out.println("\nPeople without pets:");
        for (Person p : registry.findPeopleWithoutPets()) {
            System.out.println("  " + p.getName());
        }
        
        System.out.println("\n=== Testing PhD Student restrictions ===");
        Person phd = new PhDStudent("Mike", 27, "Chemistry", 98765, 
                                    "Nanotechnology", 2);
        Animal husky = new Dog("Husky", 2, "Siberian Husky");
        Animal goldfish = new Fish("Goldie", 1, "fresh");
        
        phd.assignPet(husky);      // Should fail
        phd.assignPet(goldfish);   // Should work
        
        registry.addPerson(phd);
        registry.printRegistry();
    }
}