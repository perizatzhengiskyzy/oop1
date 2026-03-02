package problem1;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class Super_sub {
	 private String brand;
	 private String model;
	 private int year;
	 
	 public Super_sub(String brand, String model, int year) {
	        this.brand = brand;
	        this.model = model;
	        this.year = year;
	 }
	 public String getBrand() {
	        return brand;
	    }
	    
	    public void setBrand(String brand) {
	        this.brand = brand;
	    }
	    
	    public String getModel() {
	        return model;
	    }
	    
	    public void setModel(String model) {
	        this.model = model;
	    }
	    
	    public int getYear() {
	        return year;
	    }
	    
	    public void setYear(int year) {
	        this.year = year;
	    }
	    
	    @Override
	    public String toString() {
	        return brand + " " + model + " (" + year + ")";
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        Super_sub vehicle = (Super_sub) o;
	        return year == vehicle.year &&
	               Objects.equals(brand, vehicle.brand) &&
	               Objects.equals(model, vehicle.model);
	    }
	    
	    @Override
	    public int hashCode() {
	        return Objects.hash(brand, model, year);
	    }
}

class Car extends Super_sub {
    private String licensePlate;
    private int numberOfDoors;
    
    public Car(String brand, String model, int year, String licensePlate, int numberOfDoors) {
        super(brand, model, year);
        this.licensePlate = licensePlate;
        this.numberOfDoors = numberOfDoors;
    }
    
   
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [" + licensePlate + "] " + numberOfDoors + "-door";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        Car car = (Car) o;
        return numberOfDoors == car.numberOfDoors &&
               Objects.equals(licensePlate, car.licensePlate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), licensePlate, numberOfDoors);
    }
}

class TestHashSet {
    public static void main(String[] args) {
      
        Set<Car> carSet = new HashSet<>();
        
        
        Car car1 = new Car("Toyota", "Camry", 2020, "ABC123", 4);
        Car car2 = new Car("Honda", "Civic", 2021, "XYZ789", 4);
        Car car3 = new Car("Toyota", "Camry", 2020, "ABC123", 4); 
        Car car4 = new Car("Toyota", "Camry", 2020, "DEF456", 4); 
        Car car5 = new Car("Ford", "Mustang", 2022, "GT500", 2);
        
       
        System.out.println("Adding car1: " + carSet.add(car1));
        System.out.println("Adding car2: " + carSet.add(car2));
        System.out.println("Adding car3 (duplicate): " + carSet.add(car3));
        System.out.println("Adding car4: " + carSet.add(car4));
        System.out.println("Adding car5: " + carSet.add(car5));
        
        
        System.out.println("\n--- Cars in HashSet (" + carSet.size() + " items) ---");
        for (Car car : carSet) {
            System.out.println(car);
        }
        
      
        
        System.out.println("Contains car1? " + carSet.contains(car1));
        System.out.println("Contains car3 (duplicate)? " + carSet.contains(car3));
        System.out.println("Contains new Toyota Camry with ABC123? " + 
                          carSet.contains(new Car("Toyota", "Camry", 2020, "ABC123", 4)));
        
        
        
        Super_sub v1 = new Super_sub("Toyota", "Camry", 2020);
        Super_sub v2 = new Super_sub("Toyota", "Camry", 2020);
        Super_sub v3 = new Super_sub("Honda", "Civic", 2021);
        
        System.out.println("v1 equals v2? " + v1.equals(v2));
        System.out.println("v1 equals v3? " + v1.equals(v3));
    }
}
