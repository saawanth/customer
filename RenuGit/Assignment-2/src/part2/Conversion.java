package part2;

public class Conversion {
	
	private int amountPaid;
	private int amountOwed;
	
	public int change; 
	
	public int getChange() {
		return change = amountPaid - amountOwed; 
	}
	public void setChange(int change) {
		this.change = change;
	}
	public int dollars(){
				return (change / 100);
		
	}
    public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getAmountOwed() {
		return amountOwed;
	}
	public void setAmountOwed(int amountOwed) {
		this.amountOwed = amountOwed;
	}
	public int quarters(){
	return (change % 100) / 25;
}
public int dimes(){
	return (((change % 100) % 25) / 10);
}
public int nickels(){
	return ((((change % 100)%25) % 10) / 5);
}
public int cents(){
	return ((((change % 100) % 25) % 10) % 5);
	}

@Override
public String toString() {
	return (dollars()+ " "+ "dollars" + ", " + quarters()+" "+"quarters"+ ", "+ dimes()+" "+"dimes"+ ", "+ nickels()+" "+"nickels"+ ", "+ cents()+" " + "cents");
}
}
