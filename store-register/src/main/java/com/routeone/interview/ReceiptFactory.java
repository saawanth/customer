package com.routeone.interview;

public class ReceiptFactory {

	public Receipt getInstance() {
		return new StoreReceipt();
	}

}
