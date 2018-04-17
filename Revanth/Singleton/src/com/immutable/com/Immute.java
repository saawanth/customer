package com.immutable.com;
/*
 * Declare the class as final so it can’t be extended.
Make all fields private so that direct access is not allowed.
Don’t provide setter methods for variables
Make all mutable fields final so that it’s value can be assigned only once.
Initialize all the fields via a constructor performing deep copy.
Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */
public final class Immute {
	 private final int age;
	 private final String name;
	 
	 public Immute(int a, String name){
		 this.age = a;
		 this.name = name;
	 }

	public int getAge() {
		return age;
	}
	
	public String getName(){
		return name;
	}
//	 public Immute change(int age){
//		 String
//		 
//		 return
//	 }
}
