package lab1.p3;

public class main {
    public static void main(String[] args) {
        
        temperature t1 = new temperature(); 
        temperature t2 = new temperature(100); 
        temperature t3 = new temperature('F'); 
        temperature t4 = new temperature(212, 'F');
        
        
        System.out.println("t1: " + t1.getCelsius() + "°C / " + t1.getFahrenheit() + "°F");
        System.out.println("t2: " + t2.getCelsius() + "°C / " + t2.getFahrenheit() + "°F");
        System.out.println("t3: " + t3.getCelsius() + "°C / " + t3.getFahrenheit() + "°F");
        System.out.println("t4: " + t4.getCelsius() + "°C / " + t4.getFahrenheit() + "°F");

       
        t1.setTemperature(37, 'C');
        t3.setTemperature(98.6, 'F');

        System.out.println("\nПосле изменения:");
        System.out.println("t1: " + t1.getCelsius() + "°C / " + t1.getFahrenheit() + "°F");
        System.out.println("t3: " + t3.getCelsius() + "°C / " + t3.getFahrenheit() + "°F");

        
        try {
            t2.setScale('K'); 
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }
    }

}
