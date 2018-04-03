package storeInventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class StoreRegistry {

	TreeMap<String, List<Item>> map = new TreeMap<>();

	public void loadInventory(File inventoryFile) {
		String[] str = null;
		try {
			Scanner sc = new Scanner(inventoryFile);
			while (sc.hasNext()) {
				String one = sc.nextLine();
				str = one.split(",");
				String key = str[0];
				List<Item> value = new ArrayList<>();
				value.add(new Item(str[0],Double.parseDouble(str[1]), str[2]));
				map.put(key, value);
				}
			sc.close();
			System.out.println(map);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	public Receipt checkoutOrder(List<String> items) {
		List<Item> lt = new ArrayList<>();
		for(String s: items){
			lt.addAll(map.get(s));
		}
		Receipt r = new ReceiptImplementation(lt);
		return r;
	}
}
