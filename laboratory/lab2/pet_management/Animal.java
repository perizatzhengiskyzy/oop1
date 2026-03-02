package pet_management;

import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public abstract String getSound();
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " (" + age + " years old)";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age, getClass());
    }
}