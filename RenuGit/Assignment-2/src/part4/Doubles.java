package part4;

import java.util.Random;

public class Doubles {
	
	int dieValue;
	int faceValue2; 
	
	public int getFaceValue2() {
		return faceValue2;
	}

	public void setFaceValue2(int faceValue2) {
		this.faceValue2 = faceValue2;
	}

public Doubles(){
	this.dieValue = 0;
	}
   
   Random rand = new Random();
   
   public int roll(){
	   return rand.nextInt(6) + 1;
   }
   
   public int getDieValue() {
	return dieValue;
}

public void setDieValue(int dieValue) {
	this.dieValue = dieValue;
}

public boolean equals(){
	
	if(dieValue == faceValue2){
		return true;		
	}
	else{
		return false;
	}	   
   }
  
public String toString(int i) {
	
	String output = " ";
	
	if(i == 1){
		output = "One";
	}
	else if(i == 2){
		output ="Two";
	}
	else if(i==3){
		output ="Three";
	}
	else if(i ==4){
		output ="Four";
	}
	else if(i == 5){
		output ="Five";
	}
	else{
		output ="Six";
	}
	return output;
	}   
   
}
