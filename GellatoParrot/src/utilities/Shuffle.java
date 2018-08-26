package utilities;

import lists.*;

public class Shuffle {

	public IngredientsList shuffle(IngredientsList pList) {
		int counter = 0;
		while (counter != pList.getLength()) {
			int rng1 = (int) (Math.random() * pList.getLength());
			int rng2 = (int) (Math.random() * pList.getLength());
			pList.insert(pList.getNode(rng1), rng2);
			if (rng1 < rng2) {
				pList.remove(rng1);
			}else {
				pList.remove(rng1 + 1);
			}
			counter++;
		}
		return pList;

	}
}
