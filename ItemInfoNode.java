package hw2;

/**
 * The ItemInfoNode class implements an individual ItemInfoNode class 
 * which contains methods and data for an individual node containing data specified by ItemInfo
 * 
 * 
 * @author Samuel Sundararaman
 *    e-mail: samuel.sundararaman@stonybrook.edu
 *    Stony Brook ID: 111352739
 */

public class ItemInfoNode {
	
	private ItemInfo data; // The data for this ItemInfoNode
	private ItemInfoNode next; // Reference to the next ItemInfoNode
	private ItemInfoNode prev; // Reference to the previous ItemInfoNode
	
	/**
	 * Constructs an instance of the ItemInfoNode class
	 * @param d The ItemInfo object that contains the data for the ItemInfoNode
	 */
	public ItemInfoNode(ItemInfo d) {
		this.data = d;
	}
	
	public void setInfo(ItemInfo info) {
		this.data =info;
	}
	
	public ItemInfo getInfo() {
		return this.data;
	}
	
	public void setNext(ItemInfoNode node) {
		this.next = node;
	}
	
	public void setPrev(ItemInfoNode node) {
		this.prev = node;
	}
	
	public ItemInfoNode getNext() {
		return this.next;
	}
	
	public ItemInfoNode getPrev() {
		return this.prev;
	}
	public String toString() {
		String str= null;
		str = String.format("%-15s%-10s%-20s%-20s%-10s", data.getProductName(), data.getTagNumber(), data.getOriginalLocation(),data.getCurrentLocation(),data.getPrice());
		return str;
	}

}
