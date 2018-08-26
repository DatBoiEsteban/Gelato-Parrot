package utilities;

import lists.*;

public class Shuffle {

	public IngredientsList shuffle(IngredientsList pList) {
		int counter = 0;
		while (counter != pList.getLength()) {
			int rng1 = (int) (Math.random() * pList.getLength());
			int rng2 = (int) (Math.random() * pList.getLength());
			Node temp = pList.getNode(rng1);
			System.out.println("-------------------------");
			pList.remove(rng1);
			
			
			//testing
			for ( int i = 0; i < pList.getLength(); i++) {
				System.out.println(pList.getIngredient(i).toString());
			}
			System.out.println("---------");
			System.out.println(" 22222222222222222" + temp.toString());
			
			
			pList.insert(temp, rng2);
			
			
			//testing
			for ( int j = 0; j < pList.getLength(); j++) {
				System.out.println(pList.getIngredient(j).toString());
			}
			System.out.println("------");
			/*if (rng1 < rng2) {
				pList.remove(rng1);
			}else {
				pList.remove(rng1 + 1);
			}*/
			counter++;
		}
		return pList;

	}
}
