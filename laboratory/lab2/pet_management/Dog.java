package pet_management;

public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    public String getBreed() {
        return breed;
    }
    
    @Override
    public String getSound() {
        return "Woof! Woof!";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + breed + " - " + getSound();
    }
}