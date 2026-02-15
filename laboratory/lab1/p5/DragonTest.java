package lab1.p5;

public class DragonTest {
	public static void main(String[] args) {
		DragonLaunch launch = new DragonLaunch();
		 launch.kidnap(new Person("Boy1", Gender.BOY));
	        launch.kidnap(new Person("Boy2", Gender.BOY));
	        launch.kidnap(new Person("Girl1", Gender.GIRL));
	        launch.kidnap(new Person("Girl2", Gender.GIRL));

	        System.out.println("Initial line:");
	        launch.printLine();

	        boolean willEat = launch.willDragonEatOrNot();

	        System.out.println("Line after magic of love:");
	        launch.printLine();

	        if (willEat) {
	            System.out.println("Dragon will eat!");
	        } else {
	            System.out.println("Dragon will stay hungry!");
	        }
	}
}
