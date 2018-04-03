package storeInventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReceiptImplementation implements Receipt {
	List<Item> item = new ArrayList<>();

	public ReceiptImplementation(List<Item> item) {
		super();
		this.item = item;
	}

	public String getFormattedTotal() {
		double sum = 0;
		for (Item str : item) {
			sum += str.getCost();
		}
		String s = String.format("The total price is: $%.2f", sum);
		return s;
	}

	public List<String> getOrderedItems() {
		Collections.sort(item);
		List<String> lists = new ArrayList<>();
		if(item.size() == 0){
			System.out.println("Please add some items to your cart");
		}
		else{
			for (Item i : item) {
				if (!(lists.contains(i.getModel()))) {
					lists.add(i.getModel());
				}
					}
		}		
		return lists;
	}
}
