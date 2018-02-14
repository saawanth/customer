import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MobileReceipt implements Receipt {
	
	List<ItemBought> itemsbought;

	public MobileReceipt(Collection<ItemBought> itemsbought) {
		this.itemsbought= new ArrayList<>(itemsbought);
		Collections.sort(this.itemsbought, new Sortbyprice());
	}
	
	public String getFormattedTotal() {
		String formattedprice=null;
		Double totalPrice= 0.0;
		for(ItemBought i: itemsbought) {
			totalPrice += i.getQty() * i.getItem().price;
		}
		
		//System.out.println("$"+price);
		formattedprice=totalPrice.toString();
		return "$"+formattedprice;
	}
	
	public List<String> getOrderedItems(){
		List<String> Names= new ArrayList<>();
		for(ItemBought j:itemsbought) {
			Names.add(j.getItem().ComponentName);
		}
		
		//System.out.println(Names);
		return Names;
	}
}
class Sortbyprice implements Comparator<ItemBought> {
	public int compare(ItemBought a, ItemBought b) {
		if (a.getItem().price == b.getItem().price) {
			return a.getItem().ComponentName.compareTo(b.getItem().ComponentName);
		} else if(a.getItem().price>b.getItem().price) {
			return -1;
		} else if(a.getItem().price<b.getItem().price) {
			return 1;
		}
		return 0;

	}
}
