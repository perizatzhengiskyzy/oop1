// Task 1: Interface vs Abstract Class Examples

interface Flyable {
    void fly();
    void land();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    @Override
    public void fly() { System.out.println("Bird flying"); }
    @Override
    public void land() { System.out.println("Bird landing"); }
}

class Airplane implements Flyable {
    @Override
    public void fly() { System.out.println("Airplane flying"); }
    @Override
    public void land() { System.out.println("Airplane landing"); }
}

abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}