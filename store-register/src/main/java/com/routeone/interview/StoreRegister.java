package com.routeone.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.routeone.interview.Item.Builder;
import com.routeone.interview.util.Util;

public class StoreRegister {

	private final Map<String, Item> itemsMap = new HashMap<>();
	private String inventoryFile;

	private ReceiptFactory factory;

	public StoreRegister() {
	}

	public StoreRegister(String inventoryFile) {
		super();
		this.inventoryFile = inventoryFile;
	}

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

	public void init() {
		loadInventory(new File(inventoryFile));
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

		Receipt receipt = factory.getInstance();
		receipt.setItems(receiptItems);
		receipt.setTotal(total);

		return receipt;
	}

	Item getItem(String itemKey) {
		return itemsMap.get(itemKey);
	}
}