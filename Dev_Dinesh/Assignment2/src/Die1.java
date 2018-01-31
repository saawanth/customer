import java.util.Random;
public class Die1 {
int dieValue;
//constructor
/*public Die1() {
this.dieValue=0;	

}*/
public int getDieValue() {
	return dieValue;
}

public void setDieValue(int dieValue) {
	this.dieValue = dieValue;
}


public int roll() {
	Random randomNum= new Random();
	return randomNum.nextInt(6)+1;

}

public boolean equals(Die1 die2) {
	if(this.dieValue==die2.dieValue) {
		return true;
	}else {
		return false;
	}
}

@Override
public String toString() {
	if(this.dieValue==1) {
		return "One";
	}
	else if(this.dieValue==2) {
		return "Two";
	}
	else if(this.dieValue==3) {
		return "Three";
	}
	else if(this.dieValue==4) {
		return "Four";
	}
	else if(this.dieValue==5) {
		return "Five";
	}
	else if(this.dieValue==6) {
		return "Six";
	}
	return null;
	
}

}
