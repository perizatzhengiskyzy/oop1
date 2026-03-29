package week9;

public class Restaurant {
    
    public void servePizza(CanHavePizza eater) {
        eater.eatPizza(); 
        
       
        if (eater instanceof Person) {
            System.out.println("Оплата принята от человека."); 
        } else {
            System.out.println("Еда для питомца за счет заведения!");
        }
    }
}
