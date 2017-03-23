package com.routeone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.routeone.interview.Receipt;
import com.routeone.interview.StoreRegister;

public class StoreRegiaterSpringClineRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-service.xml");
		StoreRegister register = (StoreRegister) applicationContext.getBean("register");

		List<String> checkoutItems = new ArrayList<>();
		checkoutItems.add("PC1033");
		checkoutItems.add("GenericMotherboard");
////		checkoutItems.add("Mouse");
		checkoutItems.add("LCD");

		Receipt receipt = register.checkoutOrder(checkoutItems);

		System.out.println(receipt.getFormattedTotal());
		System.out.println(receipt.getOrderedItems());
	}
}
