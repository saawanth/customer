import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StoreRegister{
	
	Map<String,Item> inventory= new HashMap<>();
	
	public void loadInventory(File inventoryFile){
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(inventoryFile));
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){
			String str[]=sc.nextLine().split(",");
			Item part=new Item(str[0], Double.parseDouble(str[1]),str[2]);
			inventory.put(str[0], part);
		}
	}
	
	public Receipt checkOutOrder(List<String>items){
		List<Item> ordredItemList=new ArrayList<>();
		for(int j=0;j<items.size();j++){
			Item i=inventory.get(items.get(j));
			try{
				if(i!=null){
				ordredItemList.add(i);
				}
			}catch(NullPointerException exc){
				System.out.println("Given"+items.get(j)+"is not avail");
			}
			
		}
		
		Receipt r=new MobileReceipt(ordredItemList);
		return r;
	}
}

	
	

	