
import java.util.Scanner;

public class username {

	private static Scanner scnr;

	public static void main(String [] args) {
		System.out.println("Enter username between 0 and 10 characters");
		Name();
		}
	/*
	 * Gets the username from the player	
	 */
	public static String Name() {
		scnr = new Scanner (System.in);
		String username = scnr.nextLine();
		if (username.length() > 10 || username.length() == 0) {
			System.out.println("Error. Please enter a different username.");
			username = scnr.nextLine();
			System.out.println("Hi" + username);
		} else {
			System.out.println("Hi" + username);
		}
	return username;
	}
	
	
}

