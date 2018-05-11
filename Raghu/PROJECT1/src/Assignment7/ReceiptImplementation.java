package Assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiptImplementation implements Receipt {
	List<Item> item;

	public ReceiptImplementation(List<Item> item) {
		this.item = new ArrayList<>(item);
	}

public String getFormattedTotal() {
		System.out.println("total is");
		double sum = 0;
		
      for (Item i : item) {
			sum=sum+ i.getPrice();
			
		}
		String total = Double.toString(sum);
		return total;
		
		
	}

	public List<String> getOrderedItems() {
		Collections.sort(item);
		List<String> listNames = new ArrayList<>();
		for (Item i : item) {
			if (!listNames.contains(i.getComponentName())) {
				listNames.add(i.getComponentName());
			}
		}
		return listNames;
	}


}
