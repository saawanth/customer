package storeInventory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreInventoryMain {
	
public static void main(String args[]){
	
	StoreRegistry sr = new StoreRegistry();
	File file = new File("/Users/renuk/Desktop/Renu Training/Assignment6/src/storeInventory/InventoryFile.csv");
	Scanner sc = new Scanner(System.in);
	sr.loadInventory(file);
	System.out.println("Please enter the number of items you'd like to buy ");
	int i = sc.nextInt();
	System.out.println("Please enter the items you'd like to buy ");
	List<String> item = new ArrayList<>();
	int count = 0;
	while(count < i){
		String input = sc.next();
		item.add(input);
		count++;
			}
	Receipt r = sr.checkoutOrder(item);
	System.out.println(r.getFormattedTotal());
	System.out.println("The items bought are "+r.getOrderedItems());
}
}

