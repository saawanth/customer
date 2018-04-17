package shufflingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cardModel.Card;

//@Component
public class ShuffleAlgorithmToughImplmpl implements ShuffleAlgorithm {
	
	public List<Card> shuffle(List<Card> list) {
		Collections.shuffle(list);
		List<Card> secondList = new ArrayList<Card>(list.subList((list.size() / 2), list.size()));
		List<Card> finalList = new ArrayList<Card>();
		int j = 0;
		int k = 0;
		for (int i = 0; i < finalList.size();) {
			if (i % 2 == 0) {
				finalList.add(i, list.get(j++));
			} else {
				finalList.add(i, secondList.get(k++));
			}
		}
		System.out.println("Tough implementation");
		return list;
	}
}
