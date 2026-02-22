package p3;

public class Cat extends Animal {

    private String breed;

    // using super() without parameters
    public Cat() {
        super();
        System.out.println("Cat created");
    }

    // using super(name) with parameter
    public Cat(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // Method overriding
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    // Method overloading (different parameter list)
    public void makeSound(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Meow");
        }
    }

    @Override
    public String toString() {
        return "Cat[" + super.toString() + ", breed=" + breed + "]";
    }
}
