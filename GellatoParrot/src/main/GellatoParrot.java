package main;

import lists.IngredientsList;
import loader.IngredientLoader;
import utilities.Shuffle;

public class GellatoParrot {

	public static void main(String[] args) {
		Shuffle shuffler = new Shuffle();
		IngredientLoader p = new IngredientLoader();
		IngredientsList ing = p.getList();
		//System.out.println(ing.getNode(0).toString());
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.println(ing.getNode(j).toString());
			}
			ing =shuffler.shuffle(ing);
			System.out.println("----------------------------------------------------------------------------");
			for(int h = 0; h < 8; h++) {
				System.out.println(ing.getNode(h).toString());
			}
			System.out.println("----------------------------------------------------------------------------");
		}
	}

}
