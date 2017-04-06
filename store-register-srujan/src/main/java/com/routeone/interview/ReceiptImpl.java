package com.routeone.interview;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Created by mathur on 3/27/17.
 */
@Component
public class ReceiptImpl implements Receipt{

    Double price;
    List<String> orderedLists;

    public List<String> getOrderedLists() {

        return orderedLists;
    }

    public void setOrderedLists(List<String> orderedLists) {
        this.orderedLists = orderedLists;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getFormattedTotal() {
        return String.format("$ %,.2f",price);
    }

    @Override
    public List<String> getOrderedItems() {
        return orderedLists;
    }

	@Override
	public void setItems(List<Item> receiptItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTotal(double total) {
		// TODO Auto-generated method stub
		
	}
}
