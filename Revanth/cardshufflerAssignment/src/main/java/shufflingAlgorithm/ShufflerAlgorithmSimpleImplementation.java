package shufflingAlgorithm;

import java.util.Collections;
import java.util.List;


import cardModel.Card;

//@Component
public class ShufflerAlgorithmSimpleImplementation implements ShuffleAlgorithm {

	public List<Card> shuffle(List<Card> list) {
		Collections.shuffle(list);
		System.out.println("Simple Implementation");
		return list;
	}

}
