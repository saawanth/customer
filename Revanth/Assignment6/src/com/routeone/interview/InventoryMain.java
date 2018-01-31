package com.routeone.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InventoryMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		StoreRegister store = new StoreRegister();
		File file = new File("C:/Users/revan/Desktop/Files/Inventory.csv");
		store.loadInventory(file);
		Item item = new Item();
		Item item1 = new Item();
		System.out.println(item);
		System.out.println(item1);
		System.out.println(item == item1);
		List<String> listItems = new ArrayList<String>();
		listItems.add("PC1033");
		listItems.add("GenericMotherboard");
		listItems.add("GenericProcessor");
		listItems.add("Mouse");
		listItems.add("LCD");
		listItems.add("LCD");

		Receipt receipt = store.checkoutOrder(listItems);
		System.out.println(receipt.getFormattedTotal());
		System.out.println(receipt.getOrderedItems());
	}
}
