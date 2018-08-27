package hw2;

/**
 * The ItemInfo class implements an individual ItemInfo class 
 * which contains methods and data for an item
 * 
 * 
 * @author Samuel Sundararaman
 *    e-mail: samuel.sundararaman@stonybrook.edu
 *    Stony Brook ID: 111352739
 */

public class ItemInfo {

	private String productName;// The name of the product
	private double price;// The price of the product
	private String rfidTagNumber;// The rfidTag of the product 
	private String originalLocation;// The original location of the product
	private String currentLocation;// The current location of the product
	
	/**
	 * Constructs an instance of the ItemInfo class
	 * @param name The name of the product
	 * @param tag The rfidTag of the product
	 * @param origLoc The original location of the product
	 * @param p The price of the product
	 */
	public ItemInfo(String name, String tag, String origLoc, double p) {
		this.productName = name;
		this.price = p;
		this.rfidTagNumber = tag;
		this.originalLocation = origLoc;
		this.currentLocation = origLoc;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getTagNumber() {
		return rfidTagNumber;
	}
	
	public String getOriginalLocation() {
		return this.originalLocation;
	}
	
	public String getCurrentLocation() {
		return this.currentLocation;
	}
	
	public void setProductName(String name) {
		this.productName = name;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public void setTagNumber(String newTag) {
		this.rfidTagNumber = newTag;
	}
	
	public void setOriginalLocation(String loc) {
		this.originalLocation = loc;
	}
	
	public void setCurrentLocation(String newLoc) {
		this.currentLocation = newLoc;
	}

	
}
