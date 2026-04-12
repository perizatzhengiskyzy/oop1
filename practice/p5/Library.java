package practice5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	private static final String FILE_NAME="library.dat";
	public static void main(String[] args) {
		ArrayList<Book> books = loadLibrary();
		
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			System.out.println("\n Menu: (A)dd a book or (L)ist books or (Q)uit.");
			choice = sc.nextLine().toUpperCase();
			
			switch(choice){
			case "A":
				System.out.println("Name of author:");
				String name = sc.nextLine();
				System.out.println("Title:");
				String title = sc.nextLine();
				books.add(new Book(title , name));
				break;
			case "L":
				System.out.println("Books in library:");
				for(Book b : books) {
					System.out.println(b);
				}
				break;
			case "Q":
				saveLibrary(books);
				System.out.println("End.");
				break;
			default:
				System.out.println("Invalid choice");
		} 
		}while(!choice.equals("Q"));
		sc.close();
		
		
    }
	private static ArrayList<Book> loadLibrary(){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			return (ArrayList<Book>) ois.readObject();
			}
		catch(IOException | ClassNotFoundException e) {
			System.out.println("No existing library found, starting new.");
            return new ArrayList<>();
		}
	}
	private static void saveLibrary(ArrayList<Book> books) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			oos.writeObject(books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
