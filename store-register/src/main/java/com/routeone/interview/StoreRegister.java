package com.routeone.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.routeone.interview.StoreRegister.Item.Builder;
import com.routeone.interview.util.Util;

public class StoreRegister {

	private final Map<String, Item> itemsMap = new HashMap<>();

	public void loadInventory(File inventoryFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inventoryFile));
			String inventoryLine = br.readLine();
			while (inventoryLine != null) {
				String[] lineItemProps = inventoryLine.split(",");
				Item item = buildInventoryItem(lineItemProps);
				itemsMap.put(item.getName(), item);
				inventoryLine = br.readLine();
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to load the inventory Data", e);
		} finally {
			Util.close(br);
		}
	}

	private Item buildInventoryItem(String[] lineItemProps) {
		Builder builder = new Item.Builder();
		return builder.withName(lineItemProps[0]).withPrice(lineItemProps[1]).withCategory(lineItemProps[2]).build();
	}

	public Receipt checkoutOrder(List<String> items) {
		List<Item> receiptItems = new ArrayList<>();
		double total = 0;
		for (String itemKeyStr : items) {
			Item itm = getItem(itemKeyStr);
			if (itm == null) {
				throw new IllegalArgumentException("Item " + itemKeyStr + " not found in the registry.");
			} else {
				receiptItems.add(itm);
				total += itm.getPrice();
			}
		}

		return new StoreReceipt(receiptItems, total);
	}

	Item getItem(String itemKey) {
		return itemsMap.get(itemKey);
	}

	public static class Item {

		private String name;
		private String category;
		private double price;

		public Item(String name, String category, double price) {
			super();
			this.name = name;
			this.category = category;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public static class Builder {
			private String name;
			private String category;
			private double price;

			public Builder withName(String name) {
				this.name = name;
				return this;
			}

			public Builder withCategory(String category) {
				this.category = category;
				return this;
			}

			public Builder withPrice(String priceAsStr) {
				this.price = Double.parseDouble(priceAsStr);
				return this;
			}

			public Item build() {
				return new Item(name, category, price);
			}
		}
	}
}