package practice5;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SafeDivider {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(true) {
			try{
				System.out.println("Enter 2 num : ");
				int x1 = scan.nextInt();
                int x2 = scan.nextInt();
				int result = x1/x2;
				System.out.println("Result : " + x1 + "/" + x2 + "=" + result);
				break;
			}catch(InputMismatchException e) {
				System.out.println("Ошибка! Введите целые числа!");
				scan.nextLine();
			}
			catch(ArithmeticException e) {
				System.out.println("Ошибка! Нельзя делить на 0");
			}
			
			
		}
		scan.close();
	}
}

