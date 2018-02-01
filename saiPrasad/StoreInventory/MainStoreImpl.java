import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainStoreImpl{
	public static void main(String[] args) throws FileNotFoundException
	{
		StoreRegister sr = new StoreRegister();
		File file =new File("C:/Users/prudvi/Desktop/storeitems.csv");
		List<String> items = new ArrayList<>();
		items.addAll(Arrays.asList("PC1033","GenericMotherboard","GenericMotherboardV","GenericProcessor","LCD"));
		sr.loadInventory(file);
		Receipt r=sr.checkOutOrder(items);
		System.out.println(r.getFormattedTotal());
		System.out.println(r.getOrderedItems());
	}

}
