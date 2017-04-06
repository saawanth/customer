package com.routeone.interview.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.routeone.interview.CheckList;
import com.routeone.interview.Item;
import com.routeone.interview.Receipt;
import com.routeone.interview.StoreRegister;

@Controller
public class CheckoutController {
	
	@Autowired
	private StoreRegister register;
	

	@RequestMapping(value="/items")
	private String inventoryList(Model model){
		Collection<Item> items = register.getAllItems();
		model.addAttribute("list",items);
		return "inventoryList";
	}
	
	
	@RequestMapping(value="/checkout")
	private ModelAndView checkoutPage() {
	 
	List<String> checkItems = new ArrayList<>();
	for ( Item item : register.getAllItems()){
		checkItems.add(item.getName());
	}
	 
	//mav.addObject("itemsList", checkItems); // display in form
	ModelAndView mav = new ModelAndView("checkoutItems", "items", new CheckList(checkItems));
	return mav;
	}
	 
	@RequestMapping(value="/success")
	private ModelAndView processTeams(@ModelAttribute CheckList items) {
	ModelAndView mav = new ModelAndView("success");
	Receipt receipt = register.checkoutOrder(items.getSelectedItems());
	mav.addObject("receipt", receipt);
	return mav;
	}
	
}
