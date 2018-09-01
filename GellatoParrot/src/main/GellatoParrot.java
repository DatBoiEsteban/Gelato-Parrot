package main;

import lists.IngredientsList;
import loader.JsonLoader;

public class GellatoParrot {

	public static void main(String[] args) {
		IngredientsList p =JsonLoader.ingredientLoader();;
		for (int i = 0; i < p.getLength(); i++) {
			System.out.println(p.getIngredient(i).toString());
		}
	}

}
