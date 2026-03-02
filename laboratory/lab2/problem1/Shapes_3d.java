package problem1;
import java.lang.Math;

public abstract class Shapes_3d {
	
	
	public abstract double volume();
	public abstract double surfaceArea();

}
    

class Cylinder extends Shapes_3d{
	private double radius, height;
	public Cylinder(double r, double h) {
		this.radius = r;
		this.height = h;
	}
	@Override 
	public double volume() {
		return Math.PI * radius * radius * height;
	}
	@Override
	public double surfaceArea() {
		return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
	}
	
	public double getRadius() {
		return radius;
	}
	public double getHeight() {
		return height;
	}
}
    
   
class Cube extends Shapes_3d {
	private double side;
	
	public Cube(double s) {
		this.side = s;
	}
	@Override
	public double volume() {
		return Math.pow(side, 3);
	}
	public double surfaceArea() {
		return 6 * side * side;
	}
	public double getSide() {
		return side;
	}
}
    
class Sphere extends Shapes_3d{
	private double radius;
	
	public Sphere(double r) {
		this.radius = r;
	}
	@Override
	public double volume() {
		return (4/3) * Math.PI * Math.pow(radius, 3);
	}
	@Override
	public double surfaceArea() {
		return 4 * Math.PI * radius * radius;
	}
	public double getRadius(){
		return radius;
	}
	
	
}
   class Main {
		public static void main(String[] args) {
			Cylinder cylinder = new Cylinder(3, 5);
			Sphere sphere = new Sphere(4);
			Cube cube = new Cube(2.5);
		
		System.out.println("\nCylinder : ");
		System.out.println("Volume : " + cylinder.volume());
		System.out.println("Area : " + cylinder.surfaceArea());
		
		System.out.println("\nSphere :");
        System.out.println("  Volume : " + sphere.volume());
        System.out.println("  Area : " + sphere.surfaceArea());
        
        System.out.println("\nCube :");
        System.out.println("  Volume : " + cube.volume());
        System.out.println("  Area : " + cube.surfaceArea());
		
	}
}





















