package assignment2;



public class Dice {
	/*public int roll() {
		return 1 + (int)(Math.random() * 6);
	}*/

	
	int dievalue;
	    public Dice() {

	      }
		public Dice(int dievalue) {
		this.dievalue = dievalue;
	    }
		
		public int getDicevalue() {
			return dievalue;
		}

		public void setDicevalue(int dievalue) {
			this.dievalue = dievalue;
		}

		public int roll() {	
			return 1 + (int)(Math.random() * 6);
		}
		public boolean equals(Dice die2){
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
			 switch (dievalue) {
	            case 1:  dievalue = 1;
	            return "One";
			   case 2:  dievalue = 2;
	            return  "Two";
	            case 3:  dievalue = 3;
	            return "Three";
	            case 4:  dievalue = 4;
	            return "Four";
	            case 5:  dievalue = 5;
	            return "Five";
	            case 6:  dievalue = 6;
	            return "Six";
	            
	           
	        }
			return null;
			}
} 

