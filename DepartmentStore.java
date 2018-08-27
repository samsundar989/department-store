package hw2;

import java.util.Scanner;

/**
 * The DepartmentStore class implements an individual DepartmentStore class which creates an interface for
 * a store to track its inventory
 * 
 * 
 * @author Samuel Sundararaman e-mail: samuel.sundararaman@stonybrook.edu Stony
 *         Brook ID: 111352739
 */

public class DepartmentStore {
	private static Scanner scanner;

	/**
	 * Main method which instantiates ItemList and provides GUI for transactions
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		ItemList list = new ItemList();
		String input = "Z";
		System.out.println("Welcome! ");
		while (!input.equals("Q")) {
			System.out.print("\n"  + "C - Clean Store \n" + "I - Insert an item into the list \n"
					+ "L - List by Location \n" + "M - Move an item in the store \n" + "O - Checkout \n"
					+ "P - Print all items in store \n" + "R - Print by RFID tag number \n"
					+ "U - Update inventory system \n" + "Q - Exit the program. \n" + "\n"
					+ "Please select an option: ");
			input = scanner.nextLine().toUpperCase();
			if (input.equals("C")) {
				System.out.println("The following item(s) have been moved back to their original locations: ");
				list.cleanStore();

			}

			if (input.equals("I")) {
				String name;
				String rfid;
				String origLoc;
				double price;
				System.out.print("Enter the name: ");
				name = scanner.nextLine();
				System.out.print("Enter the RFID: ");
				rfid = scanner.nextLine().toUpperCase();
				System.out.print("Enter the original location: ");
				origLoc = scanner.nextLine().toLowerCase();
				System.out.print("Enter the price: ");
				price = Double.parseDouble(scanner.nextLine());
				list.insertInfo(name, rfid, origLoc, price);

			}

			if (input.equals("L")) {
				String loc;
				System.out.print("Enter the location: ");
				loc = scanner.nextLine().toLowerCase();
				list.printByLocation(loc);

			}

			if (input.equals("M")) {
				String rfid;
				String origLoc;
				String newLoc;
				System.out.print("Enter the RFID: ");
				rfid = scanner.nextLine().toUpperCase();
				System.out.print("Enter the original location: ");
				origLoc = scanner.nextLine().toLowerCase();
				System.out.print("Enter the new location: ");
				newLoc = scanner.nextLine().toLowerCase();
				list.moveItem(rfid, origLoc, newLoc);

			}

			if (input.equals("O")) {
				String cartNum;
				System.out.print("Enter the cart number: ");
				cartNum = scanner.nextLine().toLowerCase();
				double total = list.checkOut(cartNum);
				System.out.println("The total cost for all merchandise in cart 105 was " + total);

			}

			if (input.equals("P")) {
				list.printAll();

			}
			if (input.equals("R")) {
				String tag;
				System.out.print("Enter RFID: ");
				tag = scanner.nextLine();
				list.printByTag(tag);

			}
			if (input.equals("U")) {
				System.out.println("The following item(s) have been removed from the system: ");
				list.removeAllPurchased();

			}

		}
		System.out.println("Goodbye!");
		scanner.close();
		System.exit(0);

	}

}
