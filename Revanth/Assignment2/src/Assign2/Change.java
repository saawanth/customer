package Assign2;

public class Change {

	private int amtCusPaid;
	private int amtCusOwed;
	private int change;

	public int getAmtCusPaid() {
		return amtCusPaid;
	}

	public void setAmtCusPaid(int amtCusPaid) {
		this.amtCusPaid = amtCusPaid;
	}

	public int getAmtCusOwed() {
		return amtCusOwed;
	}

	public void setAmtCusOwed(int amtCusOwed) {
		this.amtCusOwed = amtCusOwed;
	}

	public int getChange() {
		return getAmtCusPaid()-getAmtCusOwed();
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int dollars(){
		
	return getChange()/100;	
	}
	
	public int quarters(){
		return (getChange() % 100) / 25;
	}
	
	public int dimes(){
		return ((getChange() % 100) % 25) / 10;
	}
	public int nickels(){
		return (((getChange() % 100) % 25) % 10) / 5;
	}
	public int pennies(){
		return (((getChange() % 100) % 25) % 10) % 5;
	}
	
	@Override
	public String toString() {
		return dollars() + " dollars, " + quarters() + " quarters, " + dimes() + 
				" dimes, " + nickels() + " nickels, and "+ pennies() + " pennies";
	}

}
