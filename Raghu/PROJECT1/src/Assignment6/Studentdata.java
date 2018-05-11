package Assignment6;

import java.util.HashMap;
import java.util.Map;

public class Studentdata {
public static void main(String[] args){
	HashMap<Integer,String> studentLibrary=new HashMap<Integer,String>();
	studentLibrary.put(13,"raghu");
	studentLibrary.put(14,"raghuvaran");
	studentLibrary.put(15,"raghuram");
	studentLibrary.put(16,"raghurajan");
	studentLibrary.put(17,"raghuveer");
	System.out.println(studentLibrary);
	studentLibrary.get(13);
	System.out.println(studentLibrary.size());
	System.out.println(studentLibrary.get(13));
	
	for(Map.Entry<Integer, String> Entry:studentLibrary.entrySet()){
		int key=Entry.getKey();
		String value=Entry.getValue();
		
		
		System.out.println(key+" : "+value);
	}
}
}
