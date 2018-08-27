package hw2;

/**
 * The Playlist class implements an individual SongRecord class which contains
 * methods and data for an audio file
 * 
 * 
 * @author Samuel Sundararaman e-mail: samuel.sundararaman@stonybrook.edu Stony
 *         Brook ID: 111352739
 */

public class ItemList {

	ItemInfoNode head; //The head pointer of the ItemList
	ItemInfoNode tail; //The tail pointer of the ItemList
	private int size; //Counter which tracks the size of the ItemList

	/**
	 * Constructs an instance of the ItemList class with no ItemInfoNode objects
	 */
	public ItemList() {
		this.head = new ItemInfoNode(null);
		this.tail = new ItemInfoNode(null);
		head.setNext(tail);
		head.setPrev(null);
		tail.setPrev(head);
		tail.setNext(null);
		size =0;

	}

	/**
	 * Inserts a new node into the ItemList based on RFID number
	 * Time Complexity:O(N)
	 * @param name The name of the item to be inserted
	 * @param rfidTag The RFID tag of the item to be inserted
	 * @param initPosition The initial position of the item to be inserted
	 * @param price The price of the item to be inserted
	 */
	public void insertInfo(String name, String rfidTag, String initPosition, double price) {
		ItemInfo newInfo = new ItemInfo(name, rfidTag, initPosition, price);
		ItemInfoNode newNode = new ItemInfoNode(newInfo);
		ItemInfoNode temp = head;
		if(size==0) {
			newNode.setNext(temp.getNext());
			temp.getNext().setPrev(newNode);
			temp.setNext(newNode);
			newNode.setPrev(temp);
			size++;
			
		}
		else {
			temp = head.getNext();
			if(temp.getInfo().getTagNumber().compareTo(rfidTag)>0) {
				temp.getNext().setPrev(newNode);
				newNode.setNext(temp.getNext());

				temp.setNext(newNode);
				newNode.setPrev(temp);
				size++;
				
				}
			else {
				temp = temp.getNext();
			}
			
			}
		
		

	}

	/**
	 * Removes all items from the list that have their current location as "out"
	 * Time Complexity:O(N)
	 */
	public void removeAllPurchased() {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-10s%-18s%-18s%-18s%-18s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "---------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			
			if (temp.getInfo().getCurrentLocation().equals("out")) {
				table.append("\n" + String.format("%-10s", temp.toString()));
				this.removeItem(temp);
				size--;
			}
			temp = temp.getNext();
		}
		System.out.println(table.toString());

	}

	/**
	 *  Moves an item with a given RFID tag to a new location
	 *  Time Complexity:O(N)
	 * @param rfidTag The tag of the item to be moved
	 * @param source The current location of the item to be moved
	 * @param dest The location for the item to be moved to
	 * @return True if the item was found, False if not found
	 */
	public boolean moveItem(String rfidTag, String source, String dest) {
		ItemInfoNode temp = head.getNext();
		while (!temp.getInfo().getTagNumber().equals(rfidTag)&&!temp.getInfo().getCurrentLocation().equals(source)) {
			temp = temp.getNext();
		}
		if (temp == tail) {
			return false;
		} else {
			temp.getInfo().setCurrentLocation(dest);
			return true;
		}
	}

	/**
	 * Prints all items in the list
	 * Time Complexity:O(N)
	 */
	public void printAll() {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-15s%-10s%-20s%-20s%-10s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "------------------------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			table.append("\n" + String.format("%-10s", temp.toString()));
			temp = temp.getNext();
		}
		System.out.println(table.toString());

	}

	/**
	 * Prints all the items that share a common location
	 * Time Complexity:O(N)
	 * @param location The location of the items to be printed
	 */
	public void printByLocation(String location) {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-15s%-10s%-20s%-20s%-10s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "---------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			
			if (temp.getInfo().getCurrentLocation().equals(location)) {
				table.append("\n" + String.format("%-10s", temp.toString()));
			}
			temp = temp.getNext();
		}
		System.out.println(table.toString());

	}

	/**
	 * Returns every item in the list that is not "out" or in a cart back to its original location
	 * Time Complexity:O(N)
	 */
	public void cleanStore() {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-15s%-10s%-20s%-20s%-10s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "---------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			
			if (!temp.getInfo().getCurrentLocation().equals("out")
					|| temp.getInfo().getCurrentLocation().charAt(0) != 'c') {
				if (!temp.getInfo().getOriginalLocation().equals(temp.getInfo().getCurrentLocation())) {
					table.append("\n" + String.format("%-10s", temp.toString()));
					temp.getInfo().setCurrentLocation(temp.getInfo().getOriginalLocation());
				}

			}
			temp = temp.getNext();
		}
		System.out.println(table.toString());

	}

	/**
	 * Changes the location of every item in a cart to "out"
	 * Time Complexity:O(N)
	 * @param cartNumber The number of the cart to check out
	 * @return The total price of the transaction
	 */
	public double checkOut(String cartNumber) {
		double total = 0.0;
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-15s%-10s%-20s%-20s%-10s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "---------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			
			if (temp.getInfo().getCurrentLocation().equals(cartNumber)) {
				table.append("\n" + String.format("%-10s", temp.toString()));
				temp.getInfo().setCurrentLocation("out");
				size--;
				total = total + temp.getInfo().getPrice();
			}
			temp = temp.getNext();
		}
		System.out.println(table.toString());
		return total;

	}

	/**
	 * Prints items in the list based on a given RFID tag
	 * Time Complexity:O(N)
	 * @param tag The RFID tag of the items to be printed
	 */
	public void printByTag(String tag) {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-15s%-10s%-20s%-20s%-10s", "Item Name", "RFID", "Original Location",
				"Current Location", "Price"));
		table.append("\n" + "---------------------------------------------------------");
		ItemInfoNode temp = head.getNext();
		while (temp != tail) {
			
			if(temp.getInfo().getTagNumber().equals(tag)) {
			table.append("\n" + String.format("%-10s", temp.toString()));
			}
			temp = temp.getNext();
		}
		System.out.println(table.toString());

	}

	/**
	 * Helper method to remove a given item
	 * Time Complexity:O(N)
	 * @param toRemove The item to remove from the list
	 */
	public void removeItem(ItemInfoNode toRemove) {
		ItemInfoNode temp = head.getNext();
		while (temp != toRemove) {
			temp = temp.getNext();
		}
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
		size--;
	}

}
