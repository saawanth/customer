
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StoreRegister {

	Map<String, Item> inventory = new HashMap<>();

	public void loadInventory(File inventoryFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inventoryFile));
			String line = "";
			while ((line = br.readLine()) != null) {
				String str[] = line.split(",");
				Item part = new Item(str[0], Double.parseDouble(str[1]), str[2]);
				inventory.put(str[0], part);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Receipt checkoutOrder(List<String> items) {
		Map<String, ItemBought> itemsbought = new HashMap<>();

		for (String s : items) {
			Item item = inventory.get(s);
			ItemBought itemBought = itemsbought.get(s);
			
			if (itemBought == null) {
				itemBought = new ItemBought(1, item);
				itemsbought.put(s, itemBought);
			} else {
				itemBought.incrementQty();
			}
		}
		Receipt r = new MobileReceipt(itemsbought.values());

		return r;

	}

}
