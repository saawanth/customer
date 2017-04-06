package com.routeone.interview;

import java.util.ArrayList;
import java.util.List;

public class CheckList {

	private List<String> allItems;
	private List<String> selectedItems;
	
	public List<String> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<String> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public List<String> getAllItems() {
		return allItems;
	}

	public void setAllItems(List<String> allItems) {
		this.allItems = allItems;
	}

	public CheckList(){
		
	}
	public CheckList(List<String> itemsList){
		this.allItems  = itemsList;
	}
	
}
