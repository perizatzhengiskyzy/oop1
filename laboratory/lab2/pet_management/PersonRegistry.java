package pet_management;

import java.util.*;

public class PersonRegistry {
    private List<Person> people;
    private Map<Animal, Person> petOwners; // для быстрого поиска владельца
    
    public PersonRegistry() {
        this.people = new ArrayList<>();
        this.petOwners = new HashMap<>();
    }
    
    public void addPerson(Person person) {
        people.add(person);
        if (person.hasPet()) {
            petOwners.put(person.getPet(), person);
        }
        System.out.println("Added to registry: " + person.getName());
    }
    
    public boolean removePerson(Person person) {
        if (people.remove(person)) {
            if (person.hasPet()) {
                petOwners.remove(person.getPet());
            }
            System.out.println("Removed from registry: " + person.getName());
            return true;
        }
        return false;
    }
    
    public List<Person> findPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (p.hasPet()) {
                result.add(p);
            }
        }
        return result;
    }
    
    public List<Person> findPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (!p.hasPet() && p.getPet() == null) {
                result.add(p);
            }
        }
        return result;
    }
    
    public Person findPetOwner(Animal pet) {
        return petOwners.get(pet);
    }
    
    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }
    
    public void printRegistry() {
        System.out.println("\n=== PERSON REGISTRY ===");
        System.out.println("Total people: " + people.size());
        System.out.println("\n--- All People ---");
        for (int i = 0; i < people.size(); i++) {
            System.out.println((i+1) + ". " + people.get(i));
        }
        
        System.out.println("\n--- People with pets (" + findPeopleWithPets().size() + ") ---");
        for (Person p : findPeopleWithPets()) {
            System.out.println("  " + p.getName() + ": " + p.getPet());
        }
        
        System.out.println("\n--- People without pets (" + findPeopleWithoutPets().size() + ") ---");
        for (Person p : findPeopleWithoutPets()) {
            System.out.println("  " + p.getName());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonRegistry with ").append(people.size()).append(" people:\n");
        for (Person p : people) {
            sb.append("  - ").append(p).append("\n");
        }
        return sb.toString();
    }
}