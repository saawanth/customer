package com.shuffler.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ShufflerImplementation2 implements Shuffler {

	@Override
	public List<String> shuffle(List<String> list) {
		List<String> shuffledList = new ArrayList<String>();
		Object[] deck = (Object[]) list.toArray();
			int n = 52;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = (String)deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
			shuffledList.add((String)deck[i]);
		}
		return shuffledList;
	}
}
