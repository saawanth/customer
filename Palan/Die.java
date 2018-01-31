import java.util.Random;

public class Die {

	int dievalue;

	public Die(int dievalue) {
		super();
		this.dievalue = dievalue;
	}

	public int getDievalue() {
		return dievalue;
	}

	public void setDievalue(int dievalue) {
		this.dievalue = dievalue;
	}

	public Die() {
		
	}
		public int roll() {
			Random randomNum= new Random();
			return randomNum.nextInt(6)+1;
		}
		public boolean equals(Die die2){
			if(this.dievalue== die2.dievalue) {
				return true;
			}
			else
			{
				return false;
			}
		}
		@Override
		public String toString() {
		if(this.dievalue==1){
			return "One";
		}
		else if(this.dievalue==2){
			return "Two";
		}
		else if(this.dievalue==3){
			return "Three";
       }
		else if(this.dievalue==4){
			return "Four";
		}
		else if(this.dievalue==5){
				return "Five";
		}
		else if(this.dievalue==6){
					return "Six";
				}
				return null;
			}
} 