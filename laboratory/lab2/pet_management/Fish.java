package pet_management;

public class Fish extends Animal {
    private String waterType; // "fresh" or "salt"
    
    public Fish(String name, int age, String waterType) {
        super(name, age);
        this.waterType = waterType;
    }
    
    public String getWaterType() {
        return waterType;
    }
    
    @Override
    public String getSound() {
        return "... (silence)";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + waterType + "water fish - " + getSound();
    }
}