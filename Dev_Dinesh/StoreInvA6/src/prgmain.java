import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;


public class prgmain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Load CSV file to loadInventory method
		StoreRegister str = new StoreRegister();
		File file = new File("/Users/ReshmaVegi1/computerstore.csv");
		str.loadInventory(file);
		
		List<String> hashtest = new ArrayList<>();
		hashtest.addAll(Arrays.asList("PC1033", "GenericMotherboard", "Mouse", "LCD","PC1033"));
		
		
		
		Receipt r = str.checkoutOrder(hashtest);//It returns receipt r of checkoutOrder. 'r' of checkoutOrder executes MobileReceipt Class.
		//MobileReceipt class takes list of items named itemsbought1.
		//Mobile Receipt class executes inherited methods of Receipt getFormattedTotal() and getOrderedItems().
		System.out.println("Receipt.getFormattedTotal:"+r.getFormattedTotal());
		System.out.println("Receipt.getOrderedItems:"+r.getOrderedItems());

	}

}
