package loader;

import java.util.*;
import java.io.*;
import lists.*;

public class IngredientLoader {
	public IngredientsList ingredients = new IngredientsList();

	private void readIngredients() throws Exception {
		FileReader fr = new FileReader("inventory.json");
		BufferedReader bufRead = new BufferedReader(fr);
		String myLine = null;
		int ree = 0;
		String test = null;
		Ingredient ing = new Ingredient();
		while ((myLine = bufRead.readLine()) != null) {
			String[] array1 = myLine.split(": ");
			for (int i = 0; i < array1.length; i++) {
				if (i == 1 & array1[i].length() > 2) {
					array1[1] = array1[1].substring(1, array1[1].length() - 2);
					// strings.add(array1[1]);
					test = array1[1];
					switch (ree++) {
					case 0: {
						ing = new Ingredient();
						ing.setType(test);
						break;
					}
					case 1: {
						ing.setName(test);
						break;
					}
					case 2: {
						ing.setColor(test);
						break;
					}
					case 3: {
						ing.setID(Integer.parseInt(test));
						ree = 0;
						Node pNode = new Node();
						pNode.setValor(ing);
						ingredients.add(pNode);
						break;
					}
					}
				}
			}
			
		}
		bufRead.close();
	}


	public IngredientsList getList() {
		try {
			readIngredients();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ingredients;
	}
}
