package com.routeone.interview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StoreReceipt implements Receipt {

	private static final String DEFAULT_PATTERN = "$###,###.00";

	private final DecimalFormat decimalFormat = new DecimalFormat(DEFAULT_PATTERN);;
	private List<Item> receiptItems;
	private double total;

	public StoreReceipt(List<Item> receiptItems, double total, String totalPattern) {
		super();
		this.receiptItems = receiptItems;
		Collections.sort(receiptItems, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if (o1.getPrice() == o2.getPrice()) {
					return o1.getName().compareTo(o2.getName());
				} else if (o1.getPrice() > o2.getPrice()) {
					return -1;
				} else if (o1.getPrice() < o2.getPrice()) {
					return 1;
				}
				return 0;
			}
		});

		this.total = total;
	}

	public StoreReceipt(List<Item> receiptItems, double total) {
		this(receiptItems, total, DEFAULT_PATTERN);
	}

	public StoreReceipt() {
	}

	@Override
	public String getFormattedTotal() {
		return decimalFormat.format(total);
	}

	@Override
	public List<String> getOrderedItems() {
		List<String> orderedItems = new ArrayList<>();
		for (Item itm : receiptItems) {
			orderedItems.add(itm.getName());
		}
		return orderedItems;
	}

	@Override
	public void setItems(List<Item> receiptItems) {
		this.receiptItems = receiptItems;
	}

	@Override
	public void setTotal(double total) {
		this.total = total;
	}
}
