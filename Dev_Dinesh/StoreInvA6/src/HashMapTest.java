import java.text.ParseException;
import java.util.*;
public class HashMapTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	
		
Map<String,String> hashtest= new HashMap<>();
hashtest.put("North1","North1");
hashtest.put("North2","North2");
hashtest.put("North1","North6");
hashtest.put("North3","North3");
hashtest.put("North1","North1");
hashtest.put("North2","North2");

System.out.println(hashtest);


Iterator<String> countryIterator = hashtest.keySet().iterator();
while (countryIterator.hasNext()) {
    String code = countryIterator.next();
    System.out.println(code +" " +hashtest.get(code));
}

Map<String,Integer> hashtest1= new HashMap<>();

Scanner sc  = new Scanner(System.in);
System.out.println("Enter no.of inputs to the HashMap: ");
int n = sc.nextInt();
while(n>0) {
	System.out.println("Enter the key and value pairs:");
	String key = sc.next();
	int value = sc.nextInt();
	if(hashtest1.containsKey(key)) {
		value += hashtest1.get(key);
	}
	hashtest1.put(key,value);
	n--;
}
sc.close();
Iterator<String> countryIterator1 = hashtest1.keySet().iterator();
while (countryIterator1.hasNext()) {
    String code = countryIterator1.next();
    System.out.println(code +" " +hashtest1.get(code));
}





	}

}
