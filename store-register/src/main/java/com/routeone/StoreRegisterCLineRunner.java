package com.routeone;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.routeone.interview.Receipt;
import com.routeone.interview.StoreRegister;
import com.routeone.interview.util.Util;

public class StoreRegisterCLineRunner {

	public static void main(String[] args) {
		String inventoryFile = System.getProperty("inventory.file");
		if (inventoryFile == null && args.length > 0) {
			inventoryFile = args[0];
		}

		if (inventoryFile == null) {
			inventoryFile = "sample-inventory.csv";
		}

		URL inventoryFileUrl = Util.findFile(inventoryFile);

		StoreRegister register = new StoreRegister();
		register.loadInventory(new File(inventoryFileUrl.getFile()));

		List<String> checkoutItems = new ArrayList<>();
		checkoutItems.add("PC1033");
		checkoutItems.add("GenericMotherboard");
		checkoutItems.add("Mouse");
		checkoutItems.add("LCD");

		Receipt receipt = register.checkoutOrder(checkoutItems);

		System.out.println(receipt.getFormattedTotal());
		System.out.println(receipt.getOrderedItems());
	}

}
