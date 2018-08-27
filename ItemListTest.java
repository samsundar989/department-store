package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ItemListTest {
	ItemList list;
	ItemInfoNode shirt;
	ItemInfoNode towel;
	ItemInfoNode set;
	ItemInfo forShirt;
	ItemInfo forTowel;
	ItemInfo forSet;

	@BeforeEach
	public void setUp() {
		list = new ItemList();
		forShirt = new ItemInfo("Dress Shirt", "00A5532FF", "s12345", 30.00);
		forTowel = new ItemInfo("Red Towel","0F999FABC", "s00347",18.00);
		forSet = new ItemInfo("Silverware Set", "A1111DDFF", "s90210", 50.00);
		shirt = new ItemInfoNode(forShirt);
		towel = new ItemInfoNode(forTowel);
		set = new ItemInfoNode(forSet);
		
	}
	
	/*@Test*/
	/*public void testInsertInfo() {
		list.insertInfo(name, rfidTag, initPosition, price);
		list.insertInfo(name, rfidTag, initPosition, price);
		list.insertInfo(name, rfidTag, initPosition, price);
	}*/
	
	@Test
	public void testRemoveAllPurchased() {
		
	}
	
	@Test
	public void testMoveItem() {
		

	}
	
	
	@Test
	public void testCleanStore() {
		
	}
	
	@Test
	public void testCheckOut() {
		
	}


}
