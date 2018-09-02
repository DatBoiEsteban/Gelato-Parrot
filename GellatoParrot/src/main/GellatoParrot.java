package main;

import lists.GenericList;
import loader.JsonLoader;

public class GellatoParrot {

	public static void main(String[] args) {
		GenericList<Object> p =JsonLoader.ingredientLoader();;
		for (int i = 0; i < p.getLength(); i++) {
			System.out.println(p.getValue(i).toString());
		}
	}

}
