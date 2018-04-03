package com.shuffler.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ShufflerImplementation1 implements Shuffler {

	@Override
	public List<String> shuffle(List<String> list) {
		Collections.shuffle(list);
		return list;
	}

}
