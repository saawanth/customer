package com.routeone;

import java.io.File;
import java.net.URL;

import com.routeone.interview.Receipt;
import com.routeone.interview.StoreRegister;
import com.routeone.interview.util.Util;

public class StoreRegisterCLineRunner {

	public static void main(String[] args) {
		String inventoryFile = System.getProperty("inventory.file");
		if (args.length > 0) {
			inventoryFile = args[0];
		}

		URL inventoryFileUrl = Util.findFile(inventoryFile);

		StoreRegister register = new StoreRegister();
		register.loadInventory(new File(inventoryFileUrl.getFile()));

		Receipt receipt = register.checkoutOrder(null);

		System.out.println(receipt.getFormattedTotal());
		System.out.println(receipt.getOrderedItems());
	}

}
