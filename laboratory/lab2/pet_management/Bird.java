package pet_management;

public class Bird extends Animal {
    private double wingSpan; // в см
    
    public Bird(String name, int age, double wingSpan) {
        super(name, age);
        this.wingSpan = wingSpan;
    }
    
    public double getWingSpan() {
        return wingSpan;
    }
    
    @Override
    public String getSound() {
        return "Chirp! Chirp!";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", wingspan: " + wingSpan + "cm - " + getSound();
    }
}