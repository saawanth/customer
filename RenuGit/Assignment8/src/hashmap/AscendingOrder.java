package hashmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JButton;

public class AscendingOrder {

	TreeMap<Date, List<Person>> tm = new TreeMap<>();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public void add(String str1, String str2, String str3) throws FileNotFoundException, ParseException {
		Person p = new Person(str1, str2, str3);
		if (tm.containsKey(formatter.parse(str2))) {
			ArrayList<Person> kothadi = new ArrayList<>();
			kothadi.addAll(tm.get(formatter.parse(str2)));
			kothadi.add(p);
			tm.put(formatter.parse(str2), kothadi);
		} else {
			List<Person> al = new ArrayList<>();
			al.add(p);
			tm.put(formatter.parse(str2), al);
		}
	}

	public void update() throws ParseException {
		System.out.println("Enter the date of birth of the person you'd like to update ");
		String date = sc.next();
		Date dt1 = formatter.parse(date);
		if (tm.containsKey(dt1)) {
			ArrayList<Person> kothadi1 = new ArrayList<>();
			kothadi1.addAll(tm.get(dt1));
			System.out.println("Please enter the name of the person to be updated ");
			String name = sc.next();
			System.out.println("Enter the name you'd like to update ");
			String updatedName = sc.next();
			for (int i = 0; i < kothadi1.size(); i++) {
				if (kothadi1.get(i).getName().equals(name)) {
					kothadi1.get(i).setName(updatedName);
				}
			}
			System.out.println("Updated map values " + tm.values());
		}
	}

	public void delete() throws ParseException {

		System.out.println("Enter the date of birth of the person you'd like to delete ");
		String delete = sc.next();
		Date dt1 = formatter.parse(delete);
		if (tm.containsKey(dt1)) {
			tm.get(dt1);
			ArrayList<Person> kothadi1 = new ArrayList<>();
			kothadi1.addAll(tm.get(dt1));
			System.out.println("Enter the name of the person you'd like to delete ");
			String deleteName = sc.next();
			
			for (int i = 0; i < kothadi1.size(); i++) {
				if (kothadi1.get(i).getName().equals(deleteName)) {
					kothadi1.remove(0);
				}
			}
			tm.put(dt1, kothadi1);
			System.out.println("My map values " + tm.values());
		}

	}
	public void retrieveAll() throws ParseException{
		System.out.println("Enter the date of birth to retrieve the desired information ");
		String date = sc.next();
		Date dat1 = formatter.parse(date);
		if(tm.containsKey(dat1)){
			System.out.println(tm.get(dat1));
		}		
	}
	public void beforeAfter() throws ParseException{
		System.out.println("Enter the date of birth to retrieve the desired information ");
		String date = sc.next();
		Date dat1 = formatter.parse(date);
		System.out.println("Would you like before or after information? ");
		String str = sc.next();
		if(str.equals("before")){
			for (Map.Entry<Date, List<Person>> entry : tm.entrySet())
			{
			  Date key = entry.getKey();
			  if(key.before(dat1)){
				 System.out.println("List of people before the given date: " + tm.get(key)); 
			  }			  
			}
		}
		else if(str.equals("after")){
			for (Map.Entry<Date, List<Person>> entry : tm.entrySet())
			{
			  Date key = entry.getKey();
			  if(key.after(dat1)){
				 System.out.println("List of people after the given date: " + tm.get(key)); 
			  }			  
			}
		}
		}		

	public void range() throws ParseException{
		System.out.println("Enter the range for which you'd like to fetch the person information ");
		String date = sc.next();
		Date dat1 = formatter.parse(date);
		String date1 = sc.next();
		Date dat2 = formatter.parse(date1);
		for (Map.Entry<Date, List<Person>> entry : tm.entrySet())
		{
		  Date key = entry.getKey();
		  if((key.after(dat1)) && (key.before(dat2))){
			 System.out.println("List of people between the given date range: " + tm.get(key)); 
		  }			  
		}
	}
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc = new Scanner(System.in);
		AscendingOrder ao = new AscendingOrder();
		Scanner scanner = new Scanner(new File("/Users/renuk/Desktop/Renu Training/Assignment8/maps.csv"));

		while (scanner.hasNext()) {

			String s = scanner.nextLine();
			String[] str = s.split(",");

			try {
				Date dt = ao.formatter.parse(str[1]);
			} catch (ParseException e) {
				System.out.println(e);
			}

			ao.add(str[0], str[1], str[2]);
		}
		System.out.println("My map values " + ao.tm.values());
	
			System.out.println("Enter your desired operation, 1 to Add, 2 to Update, 3 to delete, 4 to retrieve, 5 to retrieve beofre or after a given date, 6 to retrieve the people information born between a date range OR 7 to terminate: ");
			int option = sc.nextInt();

			switch (option) {
			case 1: {
				System.out.println("Enter the name you'd like to add ");
				String name = sc.next();
				System.out.println("Enter the date of birth you'd like to add ");
				String dob = sc.next();
				System.out.println("Enter the email ID you'd like to add ");
				String emailId = sc.next();
				ao.add(name, dob, emailId);
				System.out.println("My map values " + ao.tm.values());
				break;
			}
			case 2: {
				ao.update();
				break;
			}
			case 3: {
				ao.delete();
				break;
			}
			case 4:{
				ao.retrieveAll();
				break;
			}
			case 5:{
				ao.beforeAfter();
				break;
			}
			case 6:{
				ao.range();
				break;
			}
			case 7:{
				break;
			}
			}
		sc.close();
		scanner.close();
	}
}
