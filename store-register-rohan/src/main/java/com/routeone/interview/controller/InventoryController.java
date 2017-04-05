package com.routeone.interview.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.routeone.interview.StoreRegister;
import com.routeone.interview.Item;
import com.routeone.interview.Receipt;


@Controller
public class InventoryController {

	@RequestMapping(value="checkout",method=RequestMethod.POST)	
	public String checkOut(@RequestParam("inventory") ArrayList<String> list, ModelMap model) {
		Receipt receipt = register.checkoutOrder(list);
		model.put("checkout",receipt);
		return "display";
	}
	
	@Autowired
	private StoreRegister register;
	
	@RequestMapping("home")
	@ResponseBody
	public String hi() {
		return "Hello, Hi How are you.";
	}

	@RequestMapping(value = "items", method = RequestMethod.GET)	
	public String inventoryList(Model model) {
		Collection<Item> items = register.getAllItems();

		model.addAttribute("list", items);
		return "inventoryList";
	}
}
