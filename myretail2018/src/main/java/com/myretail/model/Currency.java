package com.myretail.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
	USD, INR, CNY, EUR;

	@JsonValue
	public String getValue() {
		return name();
	}

	@JsonCreator
	public static Currency create(String val) {
		Currency[] currencyTypes = Currency.values();
		for (Currency currency : currencyTypes) {
			if (currency.name().equalsIgnoreCase(val)) {
				return currency;
			}
		}
		return USD;
	}
}
