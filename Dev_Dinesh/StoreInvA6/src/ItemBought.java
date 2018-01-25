
public class ItemBought {
	private int qty;
	public ItemBought(int qty, Item item) {
		super();
		this.qty = qty;
		this.item = item;
	}
	private Item item;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void incrementQty() {
		qty +=1;
	}
	
	

}
