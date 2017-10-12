package com.routeone.interview;
//Hello
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.routeone.interview.util.Util;

public class StoreRegisterTest {

	StoreRegister storeRegister = null;

	@Before
	public void initBeforeTest() {
		File inventoryFile = findFile("sample-inventory.csv");
		storeRegister = new StoreRegister();
		storeRegister.loadInventory(inventoryFile);
	}

	@Test
	public void testLoadInventory() {
		String itemName = "PC1033";
		Item item = storeRegister.getItem(itemName);
		Assert.assertNotNull(item);
		Assert.assertEquals("PC1033", item.getName());
		Assert.assertEquals(20d, item.getPrice(), 0);
		Assert.assertEquals("RAM", item.getCategory());
	}

	@Test
	public void testReceipt() {
		List<String> item = new ArrayList<String>();
		item.add("PC1033");
		item.add("Mouse");
		item.add("PC800");

		Receipt receipt = storeRegister.checkoutOrder(item);
		Assert.assertNotNull(receipt);
		Assert.assertEquals("$49.99", receipt.getFormattedTotal());
		List<String> orderedItems = receipt.getOrderedItems();
		Assert.assertNotNull(orderedItems);
		Assert.assertEquals(3, orderedItems.size());
		Assert.assertEquals("Mouse", orderedItems.get(0));
		Assert.assertEquals("PC1033", orderedItems.get(1));
		Assert.assertEquals("PC800", orderedItems.get(2));
	}
	

	@Test
	public void testReceiptWithDupItems() {
		List<String> item = new ArrayList<String>();
		item.add("Mouse");
		item.add("PC1033");
		item.add("Mouse");

		Receipt receipt = storeRegister.checkoutOrder(item);
		Assert.assertNotNull(receipt);
		Assert.assertEquals("$60.00", receipt.getFormattedTotal());
		List<String> orderedItems = receipt.getOrderedItems();
		Assert.assertNotNull(orderedItems);
		Assert.assertEquals(3, orderedItems.size());
		Assert.assertEquals("Mouse", orderedItems.get(0));
		Assert.assertEquals("Mouse", orderedItems.get(1));
		Assert.assertEquals("PC1033", orderedItems.get(2));
	}

	private static File findFile(String filePath) {
		URL inventoryFileUrl = Util.findFile("sample-inventory.csv");
		return new File(inventoryFileUrl.getFile());
	}

}
