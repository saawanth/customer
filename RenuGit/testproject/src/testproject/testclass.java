package testproject;

import java.security.Permissions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//celebrity is someone who is known to everyone else but he does not know anyone else

//a method which will allow you to ask two people
//person will tell if they know the other person, and tell if they are a celebrity

public class testclass {
	static Set<String> persons = new HashSet<>();
	
//	list of people, defined method of who knows 
	public static void main(String[] args) {
		for(int i =0; i<args.length;i++) {
			persons.add(args[i]);//al persons are added to the set
			for(int j =0; j<args.length;j++) {
				if(i == j){//no need to compare when i and j are equal
					continue;
				}
				if(knows(args[i], args[j])){
					persons.remove(args[i]);
				}
			}
		}
		if(persons.isEmpty()){
			//no celebrity
		} else {
			for(String celeb : persons){
				System.out.println(celeb);
			}
		}
	}
	
	static boolean knows(String knower, String known){
		return true;
	}
}
