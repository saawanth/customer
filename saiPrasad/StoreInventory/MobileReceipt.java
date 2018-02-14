import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MobileReceipt implements Receipt {
	List<Item> orderedList;
	public MobileReceipt(List<Item> orderedList) {
		super();
		this.orderedList = orderedList;
	}

	@Override
	public String getFormattedTotal() {
		// TODO Auto-generated method stub
		double sum =0.0;
	
		for(Item i:orderedList){
			sum=sum+i.price;
			
		}
		String formattedprice=Double.toString(sum);
		return "$"+formattedprice;
	}

	@Override
	public List<String> getOrderedItems() {
		List<String> itmName= new ArrayList<>();
	for(Item i:orderedList){
		itmName.add(i.name);
	}
		Collections.sort(itmName);
	Set<String> ItmNameSo=new LinkedHashSet<>(itmName);
	List<String> itmName1=new ArrayList<>(ItmNameSo);
	return itmName1;
	}
	

}
