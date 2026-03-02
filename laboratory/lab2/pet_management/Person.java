package pet_management;

import java.util.Objects;

public abstract class Person {
    protected String name;
    protected int age;
    protected Animal pet;
    protected Person temporaryCaretaker;
    protected Animal petOnVacation;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
        this.temporaryCaretaker = null;
        this.petOnVacation = null;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public boolean hasPet() {
        return pet != null;
    }
    
    public Animal getPet() {
        return pet;
    }
    
    public void assignPet(Animal pet) {
        if (canHavePet(pet)) {
            this.pet = pet;
            System.out.println(name + " now owns " + pet.getName());
        } else {
            System.out.println(name + " cannot have this pet: " + pet.getClass().getSimpleName());
        }
    }
    
    public void removePet() {
        if (hasPet()) {
            System.out.println(name + " removed pet: " + pet.getName());
            this.pet = null;
        } else {
            System.out.println(name + " has no pet to remove");
        }
    }
    
    // Метод для проверки, может ли человек иметь такое животное
    protected abstract boolean canHavePet(Animal pet);
    
    public abstract String getOccupation();
    
    // Логика отпуска
    public boolean leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " has no pet to leave");
            return false;
        }
        
        if (!caretaker.canHavePet(this.pet)) {
            System.out.println(caretaker.name + " cannot take care of " + pet.getName());
            return false;
        }
        
        if (caretaker.hasPet()) {
            System.out.println(caretaker.name + " already has a pet");
            return false;
        }
        
        // Временно передаем питомца
        this.petOnVacation = this.pet;
        this.temporaryCaretaker = caretaker;
        caretaker.assignPet(this.pet);
        this.pet = null;
        
        System.out.println(name + " left " + petOnVacation.getName() + 
                          " with " + caretaker.name + " for vacation");
        return true;
    }
    
    public boolean retrievePetFrom(Person caretaker) {
        if (this.petOnVacation == null) {
            System.out.println(name + " didn't leave any pet");
            return false;
        }
        
        if (this.temporaryCaretaker != caretaker) {
            System.out.println(name + " didn't leave pet with " + caretaker.name);
            return false;
        }
        
        if (!caretaker.hasPet() || !caretaker.getPet().equals(this.petOnVacation)) {
            System.out.println(caretaker.name + " doesn't have " + petOnVacation.getName());
            return false;
        }
        
        // Забираем питомца обратно
        caretaker.removePet();
        this.pet = this.petOnVacation;
        this.petOnVacation = null;
        this.temporaryCaretaker = null;
        
        System.out.println(name + " retrieved their pet back");
        return true;
    }
    
    @Override
    public String toString() {
        String result = name + " (" + getOccupation() + "), " + age + " years old";
        if (hasPet()) {
            result += ", owns: " + pet;
        } else if (petOnVacation != null) {
            result += ", on vacation, pet with " + temporaryCaretaker.name;
        } else {
            result += ", no pet";
        }
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && 
               Objects.equals(name, person.name) &&
               Objects.equals(pet, person.pet);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age, pet);
    }
}