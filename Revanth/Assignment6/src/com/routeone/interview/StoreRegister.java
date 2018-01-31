package com.routeone.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StoreRegister {
	public Map<String, Item> map = new HashMap<>();

	public void loadInventory(File inventoryFile) {

		try {
			Scanner scan = new Scanner(inventoryFile);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] str = line.split(",");
				Item item = new Item(str[0], Double.parseDouble(str[1]), str[2]);
				map.put(str[0], item);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Receipt checkoutOrder(List<String> items) {
		List<Item> item = new ArrayList<>();
		for (String s : items) {
			item.add(map.get(s));
		}
		Receipt receipt = new ReceiptImplementation(item);
		return receipt;
	}
}
