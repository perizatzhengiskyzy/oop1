package pet_management;

public class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    @Override
    public String getSound() {
        return "Meow! Meow!";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + (isIndoor ? "indoor" : "outdoor") + 
               " cat - " + getSound();
    }
}