package Assign2;

import java.util.Random;

public class Die {

	int dieValue;

	public int getDieValue() {
		return dieValue;
	}

	public void setDieValue(int dieValue) {
		this.dieValue = dieValue;
	}
	
	public Die() //Constructor method for initializing
	{
		this.dieValue=0;
	}
	
	public int roll() //roll method to generate random number between 1 and 6
	{
		Random randomNum = new Random();
		return randomNum.nextInt(6)+1;
		
	}
	
	public boolean equals(Die die2)//equals method
	{
		if(this.dieValue == die2.dieValue){
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() //toString method to display the value in words
		{
		if(this.dieValue==1){
			return "One";
		}
		else if(this.dieValue==2){
			return "Two";
		}
		else if(this.dieValue==3){
			return "Three";
		}
		else if(this.dieValue==4){
			return "Four";
		}
		else if(this.dieValue==5){
			return "Five";
		}
		else if(this.dieValue==6){
			return "Six";
		}
		return null;
		
	}
	
	
}
