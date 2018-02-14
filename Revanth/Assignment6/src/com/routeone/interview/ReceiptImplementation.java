package com.routeone.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiptImplementation implements Receipt {
	List<Item> item = new ArrayList<>();

	public ReceiptImplementation(List<Item> list) {
		// TODO Auto-generated constructor stub
		this.item = list;
	}

	@Override
	public String getFormattedTotal() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (Item i : item) {
			sum += i.getPrice();
		}
		String tot;
		tot = String.format("The total: $%.2f", sum);
		return tot;
	}

	@Override
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
