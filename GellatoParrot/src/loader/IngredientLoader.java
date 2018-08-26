package loader;

import java.util.*;
import java.io.*;
import lists.*;

public class IngredientLoader {
	public IngredientsList ingredients = new IngredientsList();
	private ArrayList<String> strings = new ArrayList<String>();

	private void readIngredients() throws Exception {
		FileReader fr = new FileReader("inventory.json");
		BufferedReader bufRead = new BufferedReader(fr);
		String myLine = null;
		while ((myLine = bufRead.readLine()) != null) {
			String[] array1 = myLine.split(": ");
			for (int i = 0; i < array1.length; i++) {
				if (i == 1 & array1[i].length() > 2) {
					array1[1] = array1[1].substring(1, array1[1].length() - 2);
					strings.add(array1[1]);
				}
			}
		}
		bufRead.close();
		addToList();
	}

	private void addToList() {
		while (!strings.isEmpty()) {
			Ingredient ing = new Ingredient();
			ing.setType(strings.get(0));
			ing.setName(strings.get(1));
			ing.setColor(strings.get(2));
			ing.setID(Integer.parseInt(strings.get(3)));
			for (int i = 0; i < 4; i++) {
				strings.remove(0);
			}
			Node pNode = new Node();
			pNode.setValor(ing);
			ingredients.add(pNode);
		}
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
