package Assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InventoryMain {

	public static void main(String[] args) throws FileNotFoundException {
		StoreRegister SR = new StoreRegister();
		File F = new File("/Users/raghu/inventory.csv");
		SR.loadInventory(F);
		List<String> listItems = new ArrayList<String>();
		listItems.add("PC1033");
		listItems.add("PC800");
		listItems.add("GenericProcessor");
		listItems.add("GenericMotherboard");
		listItems.add("LCD");
		listItems.add("LCD");
		listItems.add("GenericMotherboardV2");
		listItems.add("Mouse");
		Receipt receipt = SR.checkoutOrder(listItems);
		System.out.println(receipt.getFormattedTotal());
		System.out.println(receipt.getOrderedItems());
	}
}
