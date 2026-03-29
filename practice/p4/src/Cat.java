package week9;

public class Cat extends Animal implements CanHavePizza { 
    @Override
    public void eatPizza() {
        System.out.println("Кот тихо ест кусочек пиццы."); 
    }
}